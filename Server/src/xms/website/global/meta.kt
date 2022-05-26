package xms.website.global

import xms.website.Construct
import java.io.FileReader

/** global_meta */
object meta {

    @JvmStatic val htmlContents : String = FileReader("global/global_meta.html").readText()

    @JvmStatic fun getMinified () : String {
        return Construct.MinifyHTML(this.htmlContents)
    }
}