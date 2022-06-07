/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.video

import org.jetbrains.annotations.NotNull
import xms.videos.Video
import xms.website.Construct
import xms.website.cookies.cookiesjs
import java.io.FileReader

/** alert.js */
object videoalertjs {

    @JvmStatic val jsContents : String = FileReader("video/videoalert.js").readText()

    @JvmStatic val premiumAdJs : String = FileReader("global/premiumad.js").readText()


    @JvmStatic fun getCompiled (@NotNull video : Video) : String {

        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append(cookiesjs.getCompiled())
        builder.append("const REAL_VIDEO_URL = \"${video.url}\";")
        builder.append(Construct.MinifyJS(jsContents))
        // builder.append(Construct.MinifyJS(premiumAdJs))
        builder.append(premiumAdJs)
        builder.append("</script>")

        return builder.toString()
    }

}