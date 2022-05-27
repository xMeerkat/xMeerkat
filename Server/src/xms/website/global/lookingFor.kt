package xms.website.global

object lookingFor {

    fun LookingFor (line : String) : String {

        return when (line.replace("@java:", "").trim().lowercase()) {
            "contactus" -> contactus.getCompiled()
            "footer" -> footer.getCompiled()
            "header" -> header.getCompiled()
            "alert" -> alertjs.getCompiled()
            "meta" -> meta.getCompiled()
            "style" -> stylesheet.getCompiled()
            else -> "Server Error."
        }


    }


}