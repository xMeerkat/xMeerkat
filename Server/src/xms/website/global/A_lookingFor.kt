package xms.website.global

import org.jetbrains.annotations.NotNull
import xms.videos.Video
import xms.website.video.Table
import xms.website.video.VidPage

object A_lookingFor {


    fun lf (line: String, video : Video) : @NotNull String {

        val VIDEO : String = """
                <h4 align="center">
	                <video id="Video" class="XMv" controls> <!-- https://en.wikipedia.org/wiki/List_of_common_resolutions -->
		                <source src="https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/verifyWithJS.mp4"type="video/mp4">
	                </video>
	            </h4>
            """.trimIndent()



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
            "video_date" -> video.date
            "video_id" -> video.ID
            "video" -> VIDEO

            
            "video_alert" -> videoalertjs.getCompiled(video)
            "video_uploader" -> "<h2 align=\"left\">Uploaded by&nbsp;<a href=\"/user/${video.author}\">${video.author}</a></h2>"

            "all_videos" -> Table.AllVideos()

            // Didn't match anything:
            else -> "Server Error."
        }
    }


}