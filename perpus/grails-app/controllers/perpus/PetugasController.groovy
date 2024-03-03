package perpus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PetugasController {

    PetugasService petugasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond petugasService.list(params), model:[petugasCount: petugasService.count()]
    }

    def show(Long id) {
        respond petugasService.get(id)
    }

    def create() {
        respond new Petugas(params)
    }

    def save(Petugas petugas) {
        if (petugas == null) {
            notFound()
            return
        }

        try {
            petugasService.save(petugas)
        } catch (ValidationException e) {
            respond petugas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'petugas.label', default: 'Petugas'), petugas.id])
                redirect petugas
            }
            '*' { respond petugas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond petugasService.get(id)
    }

    def update(Petugas petugas) {
        if (petugas == null) {
            notFound()
            return
        }

        try {
            petugasService.save(petugas)
        } catch (ValidationException e) {
            respond petugas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'petugas.label', default: 'Petugas'), petugas.id])
                redirect petugas
            }
            '*'{ respond petugas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        petugasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'petugas.label', default: 'Petugas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'petugas.label', default: 'Petugas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
