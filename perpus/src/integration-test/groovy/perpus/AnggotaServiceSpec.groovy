package perpus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AnggotaServiceSpec extends Specification {

    AnggotaService anggotaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Anggota(...).save(flush: true, failOnError: true)
        //new Anggota(...).save(flush: true, failOnError: true)
        //Anggota anggota = new Anggota(...).save(flush: true, failOnError: true)
        //new Anggota(...).save(flush: true, failOnError: true)
        //new Anggota(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //anggota.id
    }

    void "test get"() {
        setupData()

        expect:
        anggotaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Anggota> anggotaList = anggotaService.list(max: 2, offset: 2)

        then:
        anggotaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        anggotaService.count() == 5
    }

    void "test delete"() {
        Long anggotaId = setupData()

        expect:
        anggotaService.count() == 5

        when:
        anggotaService.delete(anggotaId)
        sessionFactory.currentSession.flush()

        then:
        anggotaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Anggota anggota = new Anggota()
        anggotaService.save(anggota)

        then:
        anggota.id != null
    }
}
