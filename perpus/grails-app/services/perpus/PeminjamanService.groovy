package perpus

import grails.gorm.services.Service

@Service(Peminjaman)
interface PeminjamanService {

    Peminjaman get(Serializable id)

    List<Peminjaman> list(Map args)

    Long count()

    void delete(Serializable id)

    Peminjaman save(Peminjaman peminjaman)

}