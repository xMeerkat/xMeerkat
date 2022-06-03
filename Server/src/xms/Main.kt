/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms

import xms.premium.pTokenStorage.xin as InitPremium
import xms.runners.Runner443 as Port443
import xms.runners.Runner80 as Port80


object Main {

    @JvmStatic private val runner : Thread = Thread {

        println("\nRunning xMeerkat on http://localhost:80 and http://localhost:443\n")

        val HTTP: Thread = Thread {
            Port80.main()
        }

        val HTTPS: Thread = Thread {
            Port443.main()
        }



        MAPS.addMaps()

        HTTP.start()
        HTTPS.start()
    }


    @JvmStatic fun main (args: Array<String>) : Unit {

        val handler : Thread.UncaughtExceptionHandler = Thread.UncaughtExceptionHandler { _, e ->
            e.printStackTrace()
            println("Uncaught exception: $e")
            runner.interrupt()
            revive()
        }


        Thread.setDefaultUncaughtExceptionHandler(handler)
        runner.uncaughtExceptionHandler = handler


        InitPremium()


        runner.start()
    }

    @JvmStatic fun revive () : Unit {

        runner.run()
    }



}
