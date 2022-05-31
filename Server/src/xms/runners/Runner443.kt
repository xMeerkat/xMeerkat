/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.runners

import xms.MAPS
import xms.internal.Request
import xms.internal.Server


object Runner443 {


    @JvmStatic val PORT : Int = 443


    @JvmStatic fun main () : Unit {

        var server443 : Server

        while (true) {
            server443 = Server(PORT, MAPS.mappings)
            val req: Request = server443.accept()
            server443.sendResponse(req)
            server443.shut()
        }
    }
}