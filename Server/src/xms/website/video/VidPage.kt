/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.video

import org.jetbrains.annotations.NotNull
import xms.internal.Response
import xms.videos.Video
import xms.videos.VideoList
import xms.website.Construct
import xms.website.LookingFor
import java.io.FileReader

/** The Video Page - /videos */
object VidPage {

    /** If the Video Page was mapped */
    @JvmStatic var Mapped : Boolean = false


    /** Non-compiled HTML contents of the base video */
    @JvmStatic val htmlContents : String = FileReader("video/video.html").readText()


    /** Returns the minified  */
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
                output.append(LookingFor.lf(toR, video))
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

object Table {


    @JvmStatic fun AllVideos () : String {

        val out : StringBuilder = StringBuilder()
        out.append("<table>")
        out.append("<tr>")

        var i : Int = 0


        for (video in VideoList.videos) {

            if (i >= 3) {
                out.append("</tr>")
                out.append("<tr>")
                i = 0
            }

            out.append(singleVid(video))
            i++
        }


        out.append("</tr>")
        out.append("</table>")
        return out.toString()
    }

    @JvmStatic fun singleVid (video : Video) : String {

        val out: StringBuilder = StringBuilder()

        out.append("<th scope=\"col\">")
        out.append("<figure>")
        out.append("<a href=\"/videos/${video.ID}\">")
        out.append("<img src=\"https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/${video.ID}/thumbnail.jpeg\" width=\"160\" height=\"90\">\n")
        out.append("<figcaption class=\"WhiteBoy\"><a class=\"orange-link\" href=\"/videos/${video.ID}\">${video.title}</a></figcaption>\n")
        out.append("</a>")
        out.append("</figure>")
        out.append("</th>")

        return out.toString()
    }

}