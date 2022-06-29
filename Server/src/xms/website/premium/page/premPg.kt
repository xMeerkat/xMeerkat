/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.premium.page

import xms.MAPS
import xms.internal.AbstractResponse
import xms.internal.Request
import xms.internal.Response
import xms.videos.Video
import xms.website.Construct
import xms.website.LookingFor
import java.io.FileReader

object premPg {

    @JvmStatic var Mapped : Boolean = false

    @JvmStatic val htmlContents : String = FileReader("premiumPage/premiumPage.html").readText()

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

    @JvmStatic fun map () : Unit {

        if (this.Mapped) {
            return
        }

        // xMeerkat.com/premium
        MAPS.mappings.addMap("GET", "/premium", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return premPg.response()
            }
        })

        this.Mapped = true
    }
}