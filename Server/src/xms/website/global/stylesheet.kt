/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.global

import xms.Compiler.CSSminifier.Compile as Compiler
import java.io.FileReader

/** style */
object stylesheet {

    @JvmStatic val cssContents : String = FileReader("style.css").readText()

    @JvmStatic fun getCompiled () : String {

        val output : StringBuilder = StringBuilder()
        output.append("<style>")
        output.append(Compiler(cssContents))
        output.append("</style>")

        return output.toString()
    }


}