/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.analytics

import java.io.File
import java.io.FileReader
import java.io.FileWriter

/** Reqs stands for requests, not requirements btw. */
object Reqs {


    @JvmStatic val Threshold : Int = 15



    @JvmStatic var Temp : Int = 0


    @JvmStatic fun increm (x : Int) {
        Temp += x

        if (Temp >= Threshold) {
            add(Temp)
            Temp = 0
        }
    }


    @JvmStatic fun add (amount : Int) : Unit {

            val file : File = File("reqs.txt")

            val reader : FileReader = FileReader(file)

            val content : String = reader.readText()

            val reqs : Int = Integer.parseInt(content)

            val add : Int = reqs + amount

            val output : String = add.toString()

            val writer : FileWriter = FileWriter(file)

            writer.write(output)
            writer.close()
    }


    @JvmStatic fun get () : Int {

            val file : File = File("reqs.txt")

            val reader : FileReader = FileReader(file)

            val content : String = reader.readText()

            val reqs : Int = Integer.parseInt(content)

            val out = reqs + Temp

            return out
    }





}