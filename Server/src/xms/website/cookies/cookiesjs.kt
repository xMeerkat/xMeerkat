/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.cookies

import org.jetbrains.annotations.NotNull
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*
import xms.Compiler.JSminifier.Compile as Compiler

object cookiesjs {

    @JvmStatic @NotNull val cookiesJsUrl : URL = URL("https://gist.githubusercontent.com/jasdeepkhalsa/4654184/raw/35e2c73a9d71bf206666ce2454f9c2b8b854bf6d/cookie.js")

    @JvmStatic @NotNull val jsContents : String = Scanner(cookiesJsUrl.openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next()

    @JvmStatic fun getCompiled () : String {
        return Compiler(jsContents)
    }
}