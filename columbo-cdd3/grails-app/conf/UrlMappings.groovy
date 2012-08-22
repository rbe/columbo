class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }
        "/sync/$project/$table"(controller: 'synchronize', action: 'sync')
        "/"(view: "/index")
        "500"(view: '/error')
    }

}
