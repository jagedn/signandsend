package com.puravida.software.signandsend

/**
 * Created by jorge on 12/01/16.
 */
class Documents {

    String name
    String location
    String reason

    static hasMany = [ pdfDocuments : PdfDocument ]

}
