/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms

import xms.runners.Runner443 as Port443
import xms.runners.Runner80 as Port80


object Main {


    @JvmStatic fun main (args: Array<String>) : Unit {s

        while (true) {

            try {

                println("\nRunning xMeerkat on http://localhost:80 and http://localhost:443\n")

                val HTTP: Thread = Thread {
                    Port80.main()
                }

                val HTTPS: Thread = Thread {
                    Port443.main()
                }



                MAPS.addMaps()

                HTTP.start()
                Port443.main()

            } catch (xx : Exception) {
                xx.printStackTrace()
            }


        }
    }


}
