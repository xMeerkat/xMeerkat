/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.videos;

import org.jetbrains.annotations.NotNull;
import xms.profiles.Profile;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class fast {

    public static void push (@NotNull String id, @NotNull Profile Author) {

        String title;
        Profile author;
        String url;
        String description;
        String date;
        String ID;
        Boolean ghost;

        // Title
        try {
            title = new Scanner(new URL("https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/title.txt").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        } catch (Exception ignored) { title = "server error"; }


        // Author
        author = Author;

        // Video URL
        url = "https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/video.mp4";


        // Description
        try {
            description = new Scanner(new URL("https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/description.txt").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        } catch (Exception ignored) { description = "server error"; }


        // Date
        try {
            date = new Scanner(new URL("https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/date.txt").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        } catch (Exception ignored) { date = "server error"; }

        // Video ID
        ID = id;

        // Ghost Video? (no-push)
        ghost = false;

        new Video(title, author, url, description, date, ID, ghost).Push();

        return;
    }

}
