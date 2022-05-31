/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.videos;

import org.jetbrains.annotations.NotNull;
import xms.MAPS;
import xms.internal.AbstractResponse;
import xms.internal.Request;
import xms.internal.Response;
import xms.profiles.Profile;
import xms.website.video.VidPage;

import java.net.URI;
import java.util.UUID;


public final class Video {

    /**
     * Name of the video
     */
    public final @NotNull String title;

    /**
     * Creator of the video
     */
    public final @NotNull Profile author;

    /**
     * URI to the video binary
     */
    public final @NotNull URI url;

    /**
     * Video description
     */
    public final @NotNull String description;

    /**
     * Upload Date
     */
    public final @NotNull String date;

    /**
     * Video ID
     */
    public final @NotNull String ID;


    public Video (@NotNull String title, @NotNull Profile author, @NotNull String url, @NotNull String description, @NotNull String date, @NotNull String ID, @NotNull Boolean ghost) {

        // Title Length must not be more than 100 characters
        if (title.length() > 100) {
            this.title = title.substring(0, 100);
        } else {
            this.title = title;
        }

        // Author
        this.author = author;


        // Move String URL to a URI
        this.url = URI.create(url);

        // Description Length must not be more than 1000 characters
        if (description.length() > 1000) {
            this.description = description.substring(0, 1000);
        } else {
            this.description = description;
        }


        // Move String to this.Date
        this.date = date;


        // Video ID must be a UUID
        if (ID.length() == 8) {
            this.ID = ID;
        } else {
            this.ID = UUID.randomUUID().toString().substring(0, 8);
        }

        if (!ghost) {

            VideoMap.videos.put(this.ID, this);

            VideoList.videos.add(this);
        }
    }


    public void Push () {
        MAPS.getMappings().addMap("GET", "/videos/" + this.ID, new AbstractResponse() {

            @Override
            public Response getResponse(Request req) {
                return VidPage.response(Video.this);
            }
        });
    }


    public static Video empty () {
        return new Video("Placeholder", Profile.empty(), "", "This video is a placehoder.", "", UUID.randomUUID().toString(), true);
    }
}
