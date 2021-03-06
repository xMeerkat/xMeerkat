/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.global

import xms.Compiler.JSminifier.Compile as Compiler
import xms.website.cookies.cookiesjs
import java.io.FileReader

/** alert.js */
object alertjs {

    @JvmStatic val jsContents : String = FileReader("alert.js").readText()

    @JvmStatic fun getCompiled () : String {


        val builder : StringBuilder = StringBuilder()
        builder.append("<script>")
        builder.append(cookiesjs.getCompiled())
        builder.append(Compiler(this.jsContents))
        builder.append("</script>")

        return builder.toString()
    }

}