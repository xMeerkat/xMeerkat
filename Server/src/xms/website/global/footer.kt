/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.global

import xms.website.Construct
import java.io.FileReader

/** global_footer */
object footer {

    @JvmStatic val htmlContents : String = FileReader("global/global_footer.html").readText()

    @JvmStatic fun getCompiled () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }
}