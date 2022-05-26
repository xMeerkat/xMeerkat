package xms.website.global

import java.io.FileReader

/** global_contactus */
object contactus {

    @JvmStatic val htmlContents : String = FileReader("global/global_contactus.html").readText()

    @JvmStatic fun getMinified () : String {

        val output : StringBuilder = StringBuilder()
        val ary : List<String> = this.htmlContents.split("\n")

        for (line in ary) {

            val toR = line.replace("\n", "").replace("\t", "")

            if (toR.startsWith("<!--") && toR.endsWith("-->")) {
                continue
            }
            output.append(toR)
        }


        return output.toString()
    }
}