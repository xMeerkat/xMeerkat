/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.files.httpcodes

import xms.website.Construct
import java.io.FileReader

object `403` {

    @JvmStatic val htmlContents : String = FileReader("error/403.html").readText()

    @JvmStatic fun Compile () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }


}