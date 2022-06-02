/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.external

import xms.website.Construct
import java.io.FileReader

/** twitter */
object twitter {

    @JvmStatic val htmlContents : String = FileReader("external-redirect/twitter.html").readText()

    @JvmStatic fun getCompiled () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }
}