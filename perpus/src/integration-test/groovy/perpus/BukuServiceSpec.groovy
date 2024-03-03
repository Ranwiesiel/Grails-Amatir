package perpus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BukuServiceSpec extends Specification {

    BukuService bukuService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Buku(...).save(flush: true, failOnError: true)
        //new Buku(...).save(flush: true, failOnError: true)
        //Buku buku = new Buku(...).save(flush: true, failOnError: true)
        //new Buku(...).save(flush: true, failOnError: true)
        //new Buku(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //buku.id
    }

    void "test get"() {
        setupData()

        expect:
        bukuService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Buku> bukuList = bukuService.list(max: 2, offset: 2)

        then:
        bukuList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bukuService.count() == 5
    }

    void "test delete"() {
        Long bukuId = setupData()

        expect:
        bukuService.count() == 5

        when:
        bukuService.delete(bukuId)
        sessionFactory.currentSession.flush()

        then:
        bukuService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Buku buku = new Buku()
        bukuService.save(buku)

        then:
        buku.id != null
    }
}
