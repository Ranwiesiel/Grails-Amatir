package perpus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AnggotaController {

    AnggotaService anggotaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond anggotaService.list(params), model:[anggotaCount: anggotaService.count()]
    }

    def show(Long id) {
        respond anggotaService.get(id)
    }

    def create() {
        respond new Anggota(params)
    }

    def save(Anggota anggota) {
        if (anggota == null) {
            notFound()
            return
        }

        try {
            anggotaService.save(anggota)
        } catch (ValidationException e) {
            respond anggota.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'anggota.label', default: 'Anggota'), anggota.id])
                redirect anggota
            }
            '*' { respond anggota, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond anggotaService.get(id)
    }

    def update(Anggota anggota) {
        if (anggota == null) {
            notFound()
            return
        }

        try {
            anggotaService.save(anggota)
        } catch (ValidationException e) {
            respond anggota.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'anggota.label', default: 'Anggota'), anggota.id])
                redirect anggota
            }
            '*'{ respond anggota, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        anggotaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'anggota.label', default: 'Anggota'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'anggota.label', default: 'Anggota'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
