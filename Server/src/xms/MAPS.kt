package xms

import xms.internal.AbstractResponse
import xms.internal.Mappings
import xms.internal.Request
import xms.internal.Response
import xms.v.Test_Video.test
import xms.website.files.index
import xms.website.files.httpcodes.`404`
import xms.website.external.discord
import xms.website.external.mailto
import xms.website.external.twitter
import xms.website.video.VidPage

object MAPS {

    @JvmStatic val mappings : Mappings = Mappings()

    @JvmStatic val Response_404 : Response = Response(`404`.Compile(), "404 Not Found", "text/html")



    @JvmStatic fun addMaps () {


        // xMeerkat.com/404
        mappings.addMap("GET", "/404", object : AbstractResponse () {
            override fun getResponse(request: Request): Response {
                return Response_404
            }
        })


        // xMeerkat.com/discord
        mappings.addMap("GET", "/discord", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = discord.getMinified()
                return Response(res, "200 OK", "text/html")
            }
        })


        // xMeerkat.com/twitter
        mappings.addMap("GET", "/twitter", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = twitter.getMinified()
                return Response(res, "200 OK", "text/html")
            }
        })

        // xMeerkat.com/mailto
        mappings.addMap("GET", "/mailto", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = mailto.getMinified()
                return Response(res, "200 OK", "text/html")
            }
        })

        // xMeerkat.com
        mappings.addMap("GET", "/", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return index.response()
            }
        })


        // xMeerkat.com
        mappings.addMap("GET", "/videos/test", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                return VidPage.response(test)
            }
        })



        /*
        mappings.addMap("GET", "/", "./html/index.html", "200 OK", "text/html")
        mappings.addMap("GET", "/SAVE", "./html/save.html", "200 OK", "text/html")
        mappings.addMap("POST", "/SAVE", "./html/save.html", "200 OK", "text/html")
        mappings.addMap("GET", "/dome", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                var res = "<html><body>"
                res += "Msg received:" + req.getAttribute("msg") + "<br>"
                res += "<a href='/'>Home</a>"
                res += "</body></html>"
                return Response(res, "200 OK", "text/html")
            }
        })
        */

    }

}