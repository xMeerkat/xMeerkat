package xms.website.global

import java.io.FileReader

/** style */
object stylesheet {

    @JvmStatic val cssContents : String = FileReader("style.css").readText()

    @JvmStatic fun getMinified () : String {

        val output : StringBuilder = StringBuilder()
        val ary : List<String> = this.cssContents.split("\n")

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