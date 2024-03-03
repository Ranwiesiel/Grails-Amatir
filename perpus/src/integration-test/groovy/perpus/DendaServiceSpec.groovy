package perpus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DendaServiceSpec extends Specification {

    DendaService dendaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Denda(...).save(flush: true, failOnError: true)
        //new Denda(...).save(flush: true, failOnError: true)
        //Denda denda = new Denda(...).save(flush: true, failOnError: true)
        //new Denda(...).save(flush: true, failOnError: true)
        //new Denda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //denda.id
    }

    void "test get"() {
        setupData()

        expect:
        dendaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Denda> dendaList = dendaService.list(max: 2, offset: 2)

        then:
        dendaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dendaService.count() == 5
    }

    void "test delete"() {
        Long dendaId = setupData()

        expect:
        dendaService.count() == 5

        when:
        dendaService.delete(dendaId)
        sessionFactory.currentSession.flush()

        then:
        dendaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Denda denda = new Denda()
        dendaService.save(denda)

        then:
        denda.id != null
    }
}
