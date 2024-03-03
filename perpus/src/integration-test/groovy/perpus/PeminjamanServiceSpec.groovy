package perpus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PeminjamanServiceSpec extends Specification {

    PeminjamanService peminjamanService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Peminjaman(...).save(flush: true, failOnError: true)
        //new Peminjaman(...).save(flush: true, failOnError: true)
        //Peminjaman peminjaman = new Peminjaman(...).save(flush: true, failOnError: true)
        //new Peminjaman(...).save(flush: true, failOnError: true)
        //new Peminjaman(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //peminjaman.id
    }

    void "test get"() {
        setupData()

        expect:
        peminjamanService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Peminjaman> peminjamanList = peminjamanService.list(max: 2, offset: 2)

        then:
        peminjamanList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        peminjamanService.count() == 5
    }

    void "test delete"() {
        Long peminjamanId = setupData()

        expect:
        peminjamanService.count() == 5

        when:
        peminjamanService.delete(peminjamanId)
        sessionFactory.currentSession.flush()

        then:
        peminjamanService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Peminjaman peminjaman = new Peminjaman()
        peminjamanService.save(peminjaman)

        then:
        peminjaman.id != null
    }
}
