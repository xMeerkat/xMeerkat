/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.files

import xms.MAPS
import xms.internal.AbstractResponse
import xms.internal.Request
import xms.internal.Response
import xms.videos.Video
import xms.website.Construct
import xms.website.LookingFor
import java.io.FileReader

/** The homepage of xMeerkat - / */
object index {

    @JvmStatic var Mapped : Boolean = false


    /** Non-compiled HTML contents */
    @JvmStatic val htmlContents : String = FileReader("index.html").readText()

    /** @return Minified version of htmlContents and puts the @java items. */
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

    /** @return Response to put on the mappings. */
    @JvmStatic fun response () : Response {
        return Construct.CompileResp(this.Compile(), "200 OK", "text/html", "no-cache")
    }

    @JvmStatic fun map () : Unit {

        if (this.Mapped) {
            return
        }

        // xMeerkat.com
        MAPS.mappings.addMap("GET", "/", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {

                if (req.isPremiumReq) {
                    println("[xMeerkat.com] Request is premium")
                }

                return index.response()
            }
        })

        this.Mapped = true
    }

}