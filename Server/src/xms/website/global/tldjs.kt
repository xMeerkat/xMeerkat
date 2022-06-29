/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.global

import xms.website.Construct
import xms.website.cookies.cookiesjs
import java.io.FileReader

/** tld.js */
object tldjs {

    @JvmStatic val jsContents : String = FileReader("global/tld.js").readText()

    @JvmStatic fun getCompiled () : String {


        val builder : StringBuilder = StringBuilder()
        builder.append(Construct.MinifyJS(this.jsContents))

        return builder.toString()
    }

}