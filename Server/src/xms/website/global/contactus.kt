package xms.website.global

import xms.website.Construct
import java.io.FileReader

/** global_contactus */
object contactus {

    @JvmStatic val htmlContents : String = FileReader("global/global_contactus.html").readText()

    @JvmStatic fun getMinified () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }
}