package xms.website.files.httpcodes

import xms.website.global.A_lookingFor
import java.io.FileReader

object `404` {

    @JvmStatic val htmlContents : String = FileReader("error/404.html").readText()

    @JvmStatic fun Compile () : String {


        val output : StringBuilder = StringBuilder()
        val ary : List<String> = this.htmlContents.split("\n")

        for (line in ary) {

            val toR = line.replace("\n", "").replace("\t", "")

            if (toR.replace(" ", "") == "") {
                continue
            }
            else if (toR.startsWith("<!--") && toR.endsWith("-->")) {
                continue
            }
            else if (toR.startsWith("@java")) {
                output.append(A_lookingFor.LookingFor(toR))
            } else {
                output.append(toR)
            }
        }

        return output.toString()
    }


}