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
import java.io.FileReader
import xms.Compiler.Video.Compile as Compiler

/** The Video Page - /videos */
object VidPage {

    /** If the Video Page was mapped */
    @JvmStatic var Mapped : Boolean = false


    /** Non-compiled HTML contents of the base video */
    @JvmStatic val htmlContents : String = FileReader("video/video.html").readText()




    @JvmStatic fun response (@NotNull video : Video) : Response {

        return Construct.CompileResp(Compiler(video, htmlContents), "200 OK", "text/html", "no-cache")
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

object LackingPremium {

    @JvmStatic val htmlContents : String = FileReader("premiumPage/needsPremiumVideo.html").readText()

    @JvmStatic fun response (@NotNull video : Video) : Response {

        return Construct.CompileResp(Compiler(video, htmlContents), "200 OK", "text/html", "no-cache")
    }


}