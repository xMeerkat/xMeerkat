/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.files

import xms.internal.Response
import xms.videos.Video
import xms.website.Construct
import xms.website.LookingFor
import java.io.FileReader

/** global_index */
object videos {

    @JvmStatic val htmlContents : String = FileReader("video/list.html").readText()


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
                output.append(LookingFor.lf(toR, Video.empty()))
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