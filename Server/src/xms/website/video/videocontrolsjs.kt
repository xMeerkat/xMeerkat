/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.video

import xms.Compiler
import java.io.FileReader

object videocontrolsjs {

    @JvmStatic val jsContents1 : String = FileReader("video/videocontrols.js").readText()

    @JvmStatic val jsContents2 : String = FileReader("video/videocontrolmaps.js").readText()

    @JvmStatic fun getCompiled () : String {


        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append(Compiler.JSminifier.Compile(jsContents1))
        builder.append(Compiler.JSminifier.Compile(jsContents2))
        builder.append("</script>")

        return builder.toString()
    }

}