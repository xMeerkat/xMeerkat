package xms.website.files

import xms.internal.Response
import xms.website.Construct
import xms.website.global.A_lookingFor
import java.io.FileReader

/** global_index */
object index {

    @JvmStatic val htmlContents : String = FileReader("index.html").readText()


    @JvmStatic fun Compile () : String {


        val output : StringBuilder = StringBuilder()
        val ary : List<String> = this.htmlContents.split("\n")

        output.append("<!-- Our software, xMeerkat, is open source at https://github.com/xMeerkat -->\n")

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


    @JvmStatic fun response () : Response {
        return Construct.CompileResp(this.Compile(), "200 OK", "text/html", "no-cache")
    }



}