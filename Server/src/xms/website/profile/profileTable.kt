/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.profile

import xms.profiles.Profile
import xms.videos.Video
import xms.videos.VideoList

object profileTable {


    @JvmStatic fun AllVideosFromProfile (profile: Profile) : String {

        val out : StringBuilder = StringBuilder()
        out.append("<table>")
        out.append("<tr>")

        var i : Int = 0
        var l : Int = 0


        for (video in VideoList.videos) {

            if (l >= 3) {
                out.append("</tr>")
                out.append("<tr>")
                i = 0
            }

            if (profile == video.author) {
                out.append(singleVid(video))
                l++
            }


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