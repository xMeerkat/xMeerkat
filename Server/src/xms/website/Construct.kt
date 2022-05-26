package xms.website

import org.jetbrains.annotations.NotNull
import xms.internal.Response
import java.util.*

/** HTML-Builder */
object Construct {

    /** Construct the response */
    fun CompileResp (@NotNull resp : String, @NotNull responseCode: String, @NotNull type : String, @NotNull cacheControl: String) : Response {

        val StringResp : String = grabPreResp(resp.length, responseCode, type, cacheControl) + resp

        return Response(StringResp)
    }


    /** Construct the pre-response (Start and headers) */
    fun grabPreResp (@NotNull RespLenth : Int, @NotNull responseCode : String, @NotNull type : String, @NotNull cacheControl : String): String {
        return grabStart(responseCode) + grabHeaders(RespLenth, type, cacheControl)
    }


    /** Construct HTTP start, meaning the version and the HTTP code. */
    fun grabStart (@NotNull responseCode : String) : String {

        val starts : StringBuilder = StringBuilder()

        starts.append("HTTP/1.1 $responseCode") // Current Date
        starts.append("\r\n")

        val start : String = starts.toString()

        return start
    }


    /** Construct headers */
    fun grabHeaders (@NotNull RespLenth : Int, @NotNull type : String, @NotNull cacheControl : String) : String {

        val date : Date = Date()
        val headers : StringBuilder = StringBuilder()


        headers.append("Date: $date\r\n")                   // Current Date
        headers.append("Content-Type: $type\r\n")           // Content Type (ex: text/html)
        headers.append("Content-length: $RespLenth\r\n")    // Content Length
        headers.append("Cache-Control: $cacheControl\r\n")  // Cache Control (ex. no-cache)
        headers.append("\r\n")

        val header : String = headers.toString()

        return header
    }



}