/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.profile

import org.jetbrains.annotations.NotNull
import xms.profiles.Profile
import xms.videos.Video
import java.io.FileReader

/** alert.js */
object profilealertjs {

    @JvmStatic val jsContents : String = FileReader("profile/profilealert.js").readText()

    @JvmStatic fun getMinified () : String {

        val output : StringBuilder = StringBuilder()
        val ary : List<String> = jsContents.split("\n")

        for (line in ary) {

            val toR = line.replace("\n", "").replace("\t", "")

            if (toR.startsWith("//")) {
                continue
            }
            output.append(toR)
        }

        return output.toString()
    }

    @JvmStatic fun getCompiled (@NotNull profile: Profile) : String {

        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append("const REAL_PROFILE_PFP = \"${profile.profilePicture}\";")
        builder.append(getMinified())
        builder.append("</script>")

        return builder.toString()
    }

}