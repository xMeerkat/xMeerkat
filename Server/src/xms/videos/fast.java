/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.videos;

import org.jetbrains.annotations.NotNull;
import xms.profiles.Profile;
import xms.profiles.ProfileMapN;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class fast {

    public static void push (@NotNull String id, @NotNull String Author) {

        String title;
        Profile author;
        String url;
        String description;
        String date;
        String ID;
        Boolean premium;
        Boolean ghost;

        // Title
        try {
            title = new Scanner(new URL("https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/title.txt").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        } catch (Exception ignored) { title = "server error"; }


        // Author
        author = ProfileMapN.profiles.getOrDefault(Author, Profile.empty());

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


        // Premium
        try {
            String prem = new Scanner(new URL("https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/" + id + "/premium.txt").openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
            if (prem.equals("true")) {
                premium = true;
            } else if (prem.equals("false")) {
                premium = false;
            } else {
                premium = false;
            }
        } catch (Exception ignored) { premium = false; }


        // Ghost Video? (no-push)
        ghost = false;

        final Video push = new Video(title, author, url, description, date, ID, premium, ghost);
        push.Push();

        return;
    }

}
