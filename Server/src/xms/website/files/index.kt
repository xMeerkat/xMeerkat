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
import java.io.FileReader
import xms.Compiler.Video.Compile as Compiler

/** The homepage of xMeerkat - / */
object index {

    @JvmStatic var Mapped : Boolean = false


    /** Non-compiled HTML contents */
    @JvmStatic val htmlContents : String = FileReader("index.html").readText()

    /** @return Minified version of htmlContents and puts the @java items. */
    @JvmStatic fun Compile () : String {

        return Compiler(Video.empty(), this.htmlContents)
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