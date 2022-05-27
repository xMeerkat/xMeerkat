package xms.website.global

import org.jetbrains.annotations.NotNull
import v.Video

object lookingFor {

    fun LookingFor (line : String) : @NotNull String {

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

    fun LookingFor_Video (line: String, video : Video) : @NotNull String {
        return when (line.replace("@java:", "").trim().lowercase()) {
            "contactus" -> contactus.getCompiled()
            "footer" -> footer.getCompiled()
            "header" -> header.getCompiled()
            "alert" -> alertjs.getCompiled()
            "meta" -> meta.getCompiled()
            "style" -> stylesheet.getCompiled()

            // VIDEO-SPECIFIC ONES:
            "video_meta" -> "null" // video.meta
            "video_title" -> video.name


            else -> "Server Error."
        }
    }


}