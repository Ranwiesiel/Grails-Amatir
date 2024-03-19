package perpus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PetugasServiceSpec extends Specification {

    PetugasService petugasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Petugas(...).save(flush: true, failOnError: true)
        //new Petugas(...).save(flush: true, failOnError: true)
        //Petugas petugas = new Petugas(...).save(flush: true, failOnError: true)
        //new Petugas(...).save(flush: true, failOnError: true)
        //new Petugas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //petugas.id
    }

    void "test get"() {
        setupData()

        expect:
        petugasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Petugas> petugasList = petugasService.list(max: 2, offset: 2)

        then:
        petugasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        petugasService.count() == 5
    }

    void "test delete"() {
        Long petugasId = setupData()

        expect:
        petugasService.count() == 5

        when:
        petugasService.delete(petugasId)
        sessionFactory.currentSession.flush()

        then:
        petugasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Petugas petugas = new Petugas()
        petugasService.save(petugas)

        then:
        petugas.id != null
    }
}
