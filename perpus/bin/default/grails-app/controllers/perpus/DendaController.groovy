package perpus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DendaController {

    DendaService dendaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dendaService.list(params), model:[dendaCount: dendaService.count()]
    }

    def show(Long id) {
        respond dendaService.get(id)
    }

    def create() {
        respond new Denda(params)
    }

    def save(Denda denda) {
        if (denda == null) {
            notFound()
            return
        }

        try {
            dendaService.save(denda)
        } catch (ValidationException e) {
            respond denda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'denda.label', default: 'Denda'), denda.id])
                redirect denda
            }
            '*' { respond denda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dendaService.get(id)
    }

    def update(Denda denda) {
        if (denda == null) {
            notFound()
            return
        }

        try {
            dendaService.save(denda)
        } catch (ValidationException e) {
            respond denda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'denda.label', default: 'Denda'), denda.id])
                redirect denda
            }
            '*'{ respond denda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dendaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'denda.label', default: 'Denda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'denda.label', default: 'Denda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
