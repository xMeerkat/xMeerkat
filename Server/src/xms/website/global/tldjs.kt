/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.global

import xms.Compiler.JSminifier.Compile as Compiler
import java.io.FileReader

/** tld.js */
object tldjs {

    @JvmStatic val jsContents : String = FileReader("global/tld.js").readText()

    @JvmStatic fun getCompiled () : String {


        val builder : StringBuilder = StringBuilder()
        builder.append(Compiler(this.jsContents))

        return builder.toString()
    }

}