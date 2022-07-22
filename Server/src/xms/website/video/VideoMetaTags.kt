/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.website.video

import xms.videos.Video
import java.io.FileReader

/** HTML Meta tags for video watch page */
object VideoMetaTags {

    @JvmStatic fun GetMetaTags (video : Video) : String {

        if (video == Video.empty()) {
            return FileReader("global/global_meta.html").readText()
        }



        val builder: StringBuilder = StringBuilder()

        builder.append("<meta charset=\"UTF-8\">")
        builder.append("<meta name=\"generator\" content=\"Jekyll v3.9.0\" />")
        builder.append("<meta property=\"og:title\" content=\"Watch ${video.title} on xMeerkat\" />")
        builder.append("<meta property=\"og:locale\" content=\"en_US\" />")
        builder.append("<meta name=\"description\" content=\"Watch ${video.title} on xMeerkat: ${video.description}\" />")
        builder.append("<meta property=\"og:description\" content=\"Watch ${video.title} on xMeerkat: ${video.description}\" />")
        builder.append("<link rel=\"canonical\" href=\"http://xMeerkat.com/videos/${video.ID}\" />")
        builder.append("<meta property=\"og:url\" content=\"http://xMeerkat.com/videos/${video.ID}\" />")
        builder.append("<meta property=\"og:site_name\" content=\"xMeerkat\" />")
        builder.append("<meta name=\"twitter:card\" content=\"Watch ${video.title} on xMeerkat: ${video.description}\" />")
        builder.append("<meta property=\"twitter:title\" content=\"Watch ${video.title} on xMeerkat\" />")
        builder.append("""
            <script type="application/ld+json">
                {
                    "description": "Watch ${video.title} on xMeerkat: ${video.description}",
                    "url": "http://xMeerkat.com/videos/${video.ID}",
                    "@type": "WebSite",
                    "headline": "Watch ${video.title} on xMeerkat",
                    "name": "Watch ${video.title} on xMeerkat",
                    "context": "https://schema.org"
                }
            </script>
        """.trimIndent().replace("\n", ""))
        builder.append("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">")
        builder.append("<link rel=\"preload\" href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" as=\"style\" type=\"text/css\" crossorigin>")
        builder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">")
        builder.append("<meta name=\"theme-color\" content=\"#157878\">")
        builder.append("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black-translucent\">")


        return builder.toString()
    }

}