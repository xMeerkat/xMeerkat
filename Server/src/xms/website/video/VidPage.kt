package xms.website.video

import org.jetbrains.annotations.NotNull
import xms.videos.Video
import xms.internal.Response
import xms.website.Construct
import xms.website.global.A_lookingFor
import java.io.FileReader

object VidPage {



    @JvmStatic val htmlContents : String = FileReader("video/video.html").readText()




    @JvmStatic fun Compile (@NotNull video : Video) : String {


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
                output.append(A_lookingFor.LookingFor_Video(toR, video))
            } else {
                output.append(toR)
            }
        }

        return output.toString()
    }


    @JvmStatic fun response (@NotNull video : Video) : Response {
        return Construct.CompileResp(this.Compile(video), "200 OK", "text/html", "no-cache")
    }


}