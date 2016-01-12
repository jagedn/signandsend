package com.puravida.software.signandsend

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(SignAndSendService)
class SignAndSendServiceSpec extends Specification {

    @Shared
    SignAndSendService signAndSendService

    def setup() {
        signAndSendService = service as SignAndSendService

        signAndSendService.keystoreFileName = "test.p12"
        signAndSendService.keyStorePassword= "password".toCharArray()
        signAndSendService.password = "password".toCharArray()
        signAndSendService.alias = "alias"
        signAndSendService.init()
    }

    def cleanup() {
    }

    void "sign a simple pdf"() {
        when:
        Documents docs = new Documents(name:'name',location: 'location',reason: 'reason')
        byte[]content = new FileInputStream("The Grails Framework.pdf").bytes
        PdfDocument pdf = new PdfDocument(filename: "The Grails Framework.pdf",filedata: content, document:docs)
        signAndSendService.signPdfDocument(pdf)
        if( pdf.signdata.length ){
            FileOutputStream out = new FileOutputStream("The Grails Framework Signed.pdf")
            out << pdf.signdata
        }
        then:
        pdf.signdata.length != 0
    }
}