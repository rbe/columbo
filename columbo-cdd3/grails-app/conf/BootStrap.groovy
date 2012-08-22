class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        if (!grailsApplication.config.odisync) {
            throw new IllegalStateException('Odisee Sync configuration not found! Use -Dcdd3.config.location=...')
        }
    }

    def destroy = {
    }

}
