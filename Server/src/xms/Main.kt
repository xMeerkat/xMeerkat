/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms

import java.lang.Thread.UncaughtExceptionHandler
import xms.premium.pTokenStorage.xin as InitPremiumTokens
import xms.runners.Runner443 as Port443
import xms.runners.Runner80 as Port80


object Main {


    @JvmStatic fun main (args: Array<String>) : Unit {

        val killall : UncaughtExceptionHandler = UncaughtExceptionHandler { _, throwable ->

            println(throwable.message)

            println("Uncaught exception: Doing killall")
            Runtime.getRuntime().exec("killall java")
        }




        Thread.setDefaultUncaughtExceptionHandler(killall)





        val x : Thread = Thread {


            while (true) {

                try {

                    println("\nRunning xMeerkat on http://localhost:80 and http://localhost:443\n")

                    val HTTP: Thread = Thread {
                        Port80.main()
                    }

                    val HTTPS: Thread = Thread {
                        Port443.main()
                    }

                    InitPremiumTokens()


                    MAPS.addMaps()

                    HTTP.start()
                    Port443.main()

                } catch (xx: Exception) {
                    xx.printStackTrace(System.err)
                }


            }
        }


        x.uncaughtExceptionHandler = killall

        x.start()
    }


}
