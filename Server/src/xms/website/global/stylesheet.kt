package xms.website.global

import xms.website.Construct
import java.io.FileReader

/** style */
object stylesheet {

    @JvmStatic val cssContents : String = FileReader("style.css").readText()

    @JvmStatic fun getCompiled () : String {

        val output : StringBuilder = StringBuilder()
        output.append("<style>")
        output.append(Construct.MinifyCSS(cssContents))
        output.append("</style>")

        return output.toString()
    }


}