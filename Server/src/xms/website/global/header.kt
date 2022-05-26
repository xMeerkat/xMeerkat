package xms.website.global

import xms.website.Construct
import java.io.FileReader

/** global_header */
object header {

    @JvmStatic val htmlContents : String = FileReader("global/global_header.html").readText()

    @JvmStatic fun getMinified () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }
}