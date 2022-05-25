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

        fun fromString(method: String): Methods {
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