package perpus

import grails.gorm.services.Service

@Service(Anggota)
interface AnggotaService {

    Anggota get(Serializable id)

    List<Anggota> list(Map args)

    Long count()

    void delete(Serializable id)

    Anggota save(Anggota anggota)

}