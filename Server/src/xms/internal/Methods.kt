/*
 * Original Author: https://github.com/devashish234073/Java-Socket-Http-Server
 * This file is part of a modified version of Java-Socket-Http-Server.
 * The original Java-Socket-Http-Server is open source and is unlicensed, so here's the attibution.
 * This code was modified by gemsvidø.
 */

package xms.internal

enum class Methods {


    GET,
    HEAD,
    POST,
    PUT,
    DELETE,
    CONNECT,
    OPTIONS,
    TRACE,
    PATCH;

    companion object {

        @JvmStatic fun fromString (method: String): Methods {

            return when (method.uppercase()) {
                "GET" -> GET
                "HEAD" -> HEAD
                "POST" -> POST
                "PUT" -> PUT
                "DELETE" -> DELETE
                "CONNECT" -> CONNECT
                "OPTIONS" -> OPTIONS
                "TRACE" -> TRACE
                "PATCH" -> PATCH
                else -> throw IllegalArgumentException("Unknown method: $method")
            }

        }
    }

}