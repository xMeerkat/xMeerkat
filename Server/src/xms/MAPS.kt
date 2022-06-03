/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms


import xms.internal.AbstractResponse
import xms.internal.Mappings
import xms.internal.Request
import xms.internal.Response
import xms.premium.pTokenStorage.isValidToken
import xms.profiles.ProfileRegistry
import xms.videos.VideoRegistry
import xms.website.external.discord
import xms.website.external.mailto
import xms.website.external.twitter
import xms.website.files.httpcodes.*
import xms.website.files.index
import xms.website.files.videos

object MAPS {

    @JvmStatic var mappings : Mappings = Mappings()

    @JvmStatic val Response_404 : Response = Response(`404`.Compile(), "404 Not Found", "text/html")

    @JvmStatic val Response_403 : Response = Response(`403`.Compile(), "403 Forbidden", "text/html")


    @JvmStatic fun addMaps () : Unit {



        addHTTPcodes()
        addSocials()



        // xMeerkat.com
        mappings.addMap("GET", "/", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return index.response()
            }
        })


        // xMeerkat.com/user/example
        ProfileRegistry.addProfiles()



        // xMeerkat.com/videos
        mappings.addMap("GET", "/videos", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return videos.response()
            }
        })



        VideoRegistry.addVideos()

    }


    @JvmStatic private fun addHTTPcodes () : Unit {


        // temp for dns
        mappings.addMap("GET", "/.well-known/pki-validation/43A7A7777F069378C40B842CA602AA5C.txt", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return Response("377806D045DF2C5ECA83FFDC7B0480A96306DA99B3A63C8FC64C6917250F69AF comodoca.com 629958919bc15", "200 OK", "text/plain")
            }
        })



        // xMeerkat.com/test
        mappings.addMap("GET", "/test", object : AbstractResponse () {
            override fun getResponse(request: Request): Response {


                return Response("test page for xMeerkat", "200 OK", "text/html")
            }
        })


        // xMeerkat.com/404
        mappings.addMap("GET", "/404", object : AbstractResponse () {
            override fun getResponse (request: Request): Response {

                return Response_404
            }
        })


        // xMeerkat.com/403
        mappings.addMap("GET", "/403", object : AbstractResponse () {
            override fun getResponse(request: Request): Response {

                return Response_403
            }
        })

    }

    @JvmStatic private fun addSocials () : Unit {


        // xMeerkat.com/discord
        mappings.addMap("GET", "/discord", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = discord.getCompiled()
                return Response(res, "200 OK", "text/html")
            }
        })


        // xMeerkat.com/twitter
        mappings.addMap("GET", "/twitter", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = twitter.getCompiled()
                return Response(res, "200 OK", "text/html")
            }
        })

        // xMeerkat.com/mailto
        mappings.addMap("GET", "/mailto", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = mailto.getCompiled()
                return Response(res, "200 OK", "text/html")
            }
        })

    }

}