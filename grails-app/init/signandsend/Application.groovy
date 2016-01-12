package signandsend

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.converters.JSON
import grails.converters.XML

class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {

        GrailsApp.run(Application, args)
    }
}