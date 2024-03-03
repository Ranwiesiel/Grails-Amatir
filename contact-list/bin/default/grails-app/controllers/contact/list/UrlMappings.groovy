package contact.list

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(action:"index", controller: "contact")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
