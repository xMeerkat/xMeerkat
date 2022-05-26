package xms.website.global

object lookingFor {

    fun LookingFor (line : String) : String {

        return when (line.replace("@java:", "").trim().lowercase()) {
            "contactus" -> contactus.getMinified()
            "footer" -> footer.getMinified()
            "header" -> header.getMinified()
            else -> "Server Error."
        }


    }


}