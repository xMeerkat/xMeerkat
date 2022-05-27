package xms.website.global

import org.jetbrains.annotations.NotNull
import java.io.FileReader

/** alert.js */
object videoalertjs {

    @JvmStatic val jsContents : String = FileReader("video/videoalert.js").readText()

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

    @JvmStatic fun getCompiled (@NotNull url : String) : String {

        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append("const REAL_VIDEO_URL = \"$url\";")
        builder.append(this.getMinified())
        builder.append("</script>")

        return builder.toString()
    }

}