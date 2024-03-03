package perpus

import grails.gorm.services.Service

@Service(Petugas)
interface PetugasService {

    Petugas get(Serializable id)

    List<Petugas> list(Map args)

    Long count()

    void delete(Serializable id)

    Petugas save(Petugas petugas)

}