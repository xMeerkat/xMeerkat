package xms

import xms.internal.*


object Runner80 {


    @JvmStatic val PORT : Int = 80;


    @JvmStatic fun main () : Unit {

        val mappings = Mappings()
        mappings.addMap("GET", "/", "./html/index.html")
        mappings.addMap("GET", "/SAVE", "./html/save.html")
        mappings.addMap("POST", "/SAVE", "./html/save.html")
        mappings.addMap("GET", "/dome", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                var res = "<html><body>"
                res += "Msg received:" + req.getAttribute("msg").toString() + "<br>"
                res += "<a href='/'>Home</a>"
                res += "</body></html>"
                return Response(res, "200 OK", "text/html")
            }
        })


        var server: Server
        while (true) {
            server = Server(PORT, mappings)
            val req: Request = server.accept()
            server.sendResponse(req)
            server.shut()
        }
    }
}