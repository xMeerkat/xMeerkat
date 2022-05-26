package xms.website.global

import java.io.FileReader

/** alert.js */
object alertjs {

    @JvmStatic val jsContents : String = FileReader("alert.js").readText()

    @JvmStatic fun getMinified () : String {

        val output : StringBuilder = StringBuilder()
        val ary : List<String> = this.jsContents.split("\n")

        for (line in ary) {

            val toR = line.replace("\n", "").replace("\t", "")

            if (toR.startsWith("//")) {
                continue
            }
            output.append(toR)
        }

        return output.toString()
    }

    @JvmStatic fun getCompiled () : String {

        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append(this.getMinified())
        builder.append("</script>")

        return builder.toString()
    }

}