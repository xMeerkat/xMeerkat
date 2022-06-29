/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.profile

import org.jetbrains.annotations.NotNull
import xms.internal.Response
import xms.profiles.Profile
import xms.website.Construct
import xms.website.LookingFor
import java.io.FileReader

object ProfilePage {

    @JvmStatic val htmlContents : String = FileReader("profile/profile.html").readText()


    @JvmStatic fun Compile (@NotNull profile: Profile) : String {


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
                output.append(LookingFor.lf(toR, profile))
            } else {
                output.append(toR)
            }
        }

        return output.toString()
    }

    @JvmStatic fun response (@NotNull profile: Profile) : Response {

        return Construct.CompileResp(this.Compile(profile), "200 OK", "text/html", "no-cache")
    }


}