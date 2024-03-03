package perpus

import grails.gorm.services.Service

@Service(Buku)
interface BukuService {

    Buku get(Serializable id)

    List<Buku> list(Map args)

    Long count()

    void delete(Serializable id)

    Buku save(Buku buku)

}