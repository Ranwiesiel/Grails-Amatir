package perpus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BukuController {

    BukuService bukuService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bukuService.list(params), model:[bukuCount: bukuService.count()]
    }

    def show(Long id) {
        respond bukuService.get(id)
    }

    def create() {
        respond new Buku(params)
    }

    def save(Buku buku) {
        if (buku == null) {
            notFound()
            return
        }

        try {
            bukuService.save(buku)
        } catch (ValidationException e) {
            respond buku.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'buku.label', default: 'Buku'), buku.id])
                redirect buku
            }
            '*' { respond buku, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bukuService.get(id)
    }

    def update(Buku buku) {
        if (buku == null) {
            notFound()
            return
        }

        try {
            bukuService.save(buku)
        } catch (ValidationException e) {
            respond buku.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'buku.label', default: 'Buku'), buku.id])
                redirect buku
            }
            '*'{ respond buku, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bukuService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'buku.label', default: 'Buku'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'buku.label', default: 'Buku'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
