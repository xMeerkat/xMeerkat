/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.runners

import xms.MAPS
import xms.internal.Request
import xms.internal.Server


object Runner80 {


    @JvmStatic val PORT : Int = 80


    @JvmStatic fun main () : Unit {

        var server80 : Server

        while (true) {
            server80 = Server (PORT, MAPS.mappings)
            val req : Request = server80.accept()
            server80.sendResponse(req)
            server80.shut()
        }
    }
}