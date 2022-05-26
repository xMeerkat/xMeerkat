package xms

import xms.internal.AbstractResponse
import xms.internal.Mappings
import xms.internal.Request
import xms.internal.Response
import java.io.FileReader

object MAPS {

    @JvmStatic val mappings : Mappings = Mappings()

    @JvmStatic val Html404_Contents : String = FileReader("404.html").readText()

    @JvmStatic val Response_404 : Response = Response(Html404_Contents, "404 Not Found", "text/html")



    @JvmStatic fun addMaps () {


        // 404
        mappings.addMap("GET", "/404", "404.html", "404 Not Found", "text/html")


        // Discord server
        mappings.addMap("GET", "/discord", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = """
                <html>    
                    <script>
                    
                    window.location = "https://dsc.gg/xmeerkat";
                    
                    </script>
                </html>
                """
                return Response(res, "200 OK", "text/html")
            }
        })


        // Twitter
        mappings.addMap("GET", "/twitter", object : AbstractResponse() {
            override fun getResponse(req: Request): Response {
                val res : String = """
                <html>    
                    <script>
                    
                    window.location = "https://twitter.com/XmeerkatC";
                    
                    </script>
                </html>
                """
                return Response(res, "200 OK", "text/html")
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