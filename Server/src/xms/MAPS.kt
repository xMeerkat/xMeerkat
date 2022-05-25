package xms

import xms.internal.AbstractResponse
import xms.internal.Mappings
import xms.internal.Request
import xms.internal.Response

object MAPS {

    @JvmStatic val mappings = Mappings()


    @JvmStatic fun addMaps () {

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

    }

}