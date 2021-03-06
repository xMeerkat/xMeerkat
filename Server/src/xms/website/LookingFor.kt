/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website

import org.jetbrains.annotations.NotNull
import xms.profiles.Profile
import xms.videos.Video
import xms.website.cookies.cookiesjs
import xms.website.global.*
import xms.website.profile.profileTable
import xms.website.profile.profileWidget
import xms.website.profile.profilealertjs
import xms.website.video.Table
import xms.website.video.VideoMetaTags
import xms.website.video.videoalertjs
import xms.website.video.videocontrolsjs

object LookingFor {


    @JvmStatic fun lf (line: @NotNull String,  video : @NotNull Video) : @NotNull String {

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
            "meta" -> if (video == Video.empty()) { meta.getCompiled() } else { VideoMetaTags.GetMetaTags(video) }
            "style" -> stylesheet.getCompiled()
            "cjs" -> cookiesjs.getCompiled()
            "video_controls" -> videocontrolsjs.getCompiled()

            // VIDEO-SPECIFIC ONES:
            "video_title" -> video.title
            "video_author_username" -> video.author.username
            "video_author_name" -> video.author.name
            "video_url" -> video.url.toString()
            "video_description" -> video.description
            "video_date" -> video.date
            "video_id" -> video.ID
            "video" -> VIDEO

            
            "video_alert" -> videoalertjs.getCompiled(video)
            "video_uploader" -> "<h2 align=\"left\">Uploaded by&nbsp;<a href=\"/user/${video.author.username}\">${video.author.name}</a></h2>"

            "all_videos" -> Table.AllVideos()

            // Didn't match anything:
            else -> "Server Error."
        }
    }

    @JvmStatic fun lf (line: @NotNull String, profile : @NotNull Profile) : @NotNull String {



        return when (line.replace("@java:", "").trim().lowercase()) {

            // Common codes
            "contactus" -> contactus.getCompiled()
            "footer" -> footer.getCompiled()
            "header" -> header.getCompiled()
            "alert" -> alertjs.getCompiled()
            "meta" -> meta.getCompiled()
            "style" -> stylesheet.getCompiled()
            "cjs" -> cookiesjs.getCompiled()
            "video_controls" -> videocontrolsjs.getCompiled()


            // PROFILE-SPECIFIC ONES:
            "profile_username" -> profile.username
            "profile_atusername" -> "@" + profile.username
            "profile_name" -> profile.name
            "profile_type" -> profile.accType.toString().lowercase().capitalize()
            "profile_bio" -> profile.bio
            "profile_id" -> profile.ID
            "profile" -> {
                if (profile.ID == "b572ddc8") { // DELGADO
                    profileWidget.make(profile) + "<br><h4 align=center><iframe src=\"https://cambrianacademy.org/headmaster.html\" width=960 height=540></iframe></h4><br>"
                } else {
                    profileWidget.make(profile)
                }
            }
            "profile_all_videos" -> profileTable.AllVideosFromProfile(profile)


            "profile_alert" -> profilealertjs.getCompiled(profile)

            // Didn't match anything:
            else -> "Server Error."
        }
    }



}