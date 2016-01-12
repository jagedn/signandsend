package com.puravida.software.signandsend

/**
 * Created by jorge on 12/01/16.
 */
class Documents {

    String  name
    String  location
    String  reason
    Date    signedAt

    static hasMany = [ pdfDocuments : PdfDocument ]
    static constraints = {
        signedAt(nullable: true)
    }
}
