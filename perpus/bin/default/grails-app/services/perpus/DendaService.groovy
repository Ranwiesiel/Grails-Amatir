package perpus

import grails.gorm.services.Service

@Service(Denda)
interface DendaService {

    Denda get(Serializable id)

    List<Denda> list(Map args)

    Long count()

    void delete(Serializable id)

    Denda save(Denda denda)

}