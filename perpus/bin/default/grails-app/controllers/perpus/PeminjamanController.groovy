package perpus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PeminjamanController {

    PeminjamanService peminjamanService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond peminjamanService.list(params), model:[peminjamanCount: peminjamanService.count()]
    }

    def show(Long id) {
        respond peminjamanService.get(id)
    }

    def create() {
        respond new Peminjaman(params)
    }

    def save(Peminjaman peminjaman) {
        if (peminjaman == null) {
            notFound()
            return
        }

        try {
            peminjamanService.save(peminjaman)
        } catch (ValidationException e) {
            respond peminjaman.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'peminjaman.label', default: 'Peminjaman'), peminjaman.id])
                redirect peminjaman
            }
            '*' { respond peminjaman, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond peminjamanService.get(id)
    }

    def update(Peminjaman peminjaman) {
        if (peminjaman == null) {
            notFound()
            return
        }

        try {
            peminjamanService.save(peminjaman)
        } catch (ValidationException e) {
            respond peminjaman.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'peminjaman.label', default: 'Peminjaman'), peminjaman.id])
                redirect peminjaman
            }
            '*'{ respond peminjaman, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        peminjamanService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'peminjaman.label', default: 'Peminjaman'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'peminjaman.label', default: 'Peminjaman'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
