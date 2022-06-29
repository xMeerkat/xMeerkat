/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.premium.js

import org.jetbrains.annotations.NotNull
import xms.profiles.Profile
import xms.website.Construct
import xms.website.cookies.cookiesjs
import java.io.FileReader

/** paypal.html */
object paypalhtml {

    @JvmStatic val htmlContents : String = FileReader("premiumPage/paypal.html").readText()


    @JvmStatic fun getCompiled () : String {

        return Construct.MinifyHTML(htmlContents)
    }

}