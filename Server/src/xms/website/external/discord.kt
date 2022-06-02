/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.external

import xms.website.Construct
import java.io.FileReader

/** discord */
object discord {

    @JvmStatic val htmlContents : String = FileReader("external-redirect/discord.html").readText()

    @JvmStatic fun getCompiled () : String {

        return Construct.MinifyHTML(this.htmlContents)
    }
}