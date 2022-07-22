/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms


import xms.internal.AbstractResponse
import xms.internal.Mappings
import xms.internal.Request
import xms.internal.Response
import xms.profiles.ProfileRegistry
import xms.videos.VideoRegistry
import xms.website.external.discord
import xms.website.external.mailto
import xms.website.external.twitter
import xms.website.files.httpcodes.*
import xms.website.files.index
import xms.website.files.videos
import xms.website.premium.page.premPg

object MAPS {

    @JvmStatic var mappings : Mappings = Mappings()

    @JvmStatic val Response_404 : Response = Response(`404`.Compile(), "404 Not Found", "text/html")

    @JvmStatic val Response_403 : Response = Response(`403`.Compile(), "403 Forbidden", "text/html")


    @JvmStatic fun addMaps () : Unit {


        // xMeerkat.com/<httpcode>
        addHTTPcodes()

        // xMeerkat.com/discord
        addSocials()


        // xMeerkat.com/
        index.map()


        // xMeerkat.com/user/<username>
        ProfileRegistry.addProfiles()



        // xMeerkat.com/videos
        mappings.addMap("GET", "/videos", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return videos.response()
            }
        })


        // xMeerkat.com/videos/<videoid>
        VideoRegistry.addVideos()


        // xMeerkat.com/premium
        premPg.map()

        // xMeerkat.com/analytics
        mappings.addMap("POST", "/analytics", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {

                val builder : StringBuilder = StringBuilder()

                builder.append(req.toString())

                builder.append(req.getAttribute("ip"))

                return Response("", "200 OK", "text/plain")
            }
        })



    }


    @JvmStatic private fun addHTTPcodes () : Unit {


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