package xms.website.global

import org.jetbrains.annotations.NotNull
import xms.v.Video

object A_lookingFor {

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

            // Common codes
            "contactus" -> contactus.getCompiled()
            "footer" -> footer.getCompiled()
            "header" -> header.getCompiled()
            "alert" -> alertjs.getCompiled()
            "meta" -> meta.getCompiled()
            "style" -> stylesheet.getCompiled()

            // VIDEO-SPECIFIC ONES:
            "video_title" -> video.title
            "video_author" -> video.author
            "video_url" -> video.url.toString()
            "video_description" -> video.description
            "video_date" -> video.date.toString()
            "video_id" -> video.ID.toString()

            "video_alert" -> videoalertjs.getCompiled(video.url.toString())
            "video_uploader" -> "<h2 align=\"left\">Uploaded by&nbsp;<a href=\"/user/${video.author}\">${video.author}</a></h2>"


            // Didn't match anything:
            else -> "Server Error."
        }
    }


}