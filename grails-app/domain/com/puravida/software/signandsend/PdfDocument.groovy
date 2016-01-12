package com.puravida.software.signandsend

class PdfDocument {

    String filename
    byte[] filedata
    byte[] signdata

    static constraints = {
        filename(blank:false,nullable:false)
        filedata(blank: true, nullable:true, maxSize:1024*1024*1024)
        signdata(blank: true, nullable:true, maxSize:1024*1024*1024)
    }

    Documents document
    static belongsTo = Documents
}
