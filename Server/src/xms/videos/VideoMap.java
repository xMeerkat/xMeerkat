/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.videos;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public final @NotNull class VideoMap {

    private static final @NotNull HashMap<String, Video> videos = new HashMap<>();

    public static void put (@NotNull String ID, @NotNull Video video) {
        videos.put(ID, video);
    }

    public static @NotNull Video get (@NotNull String ID) {
        return videos.getOrDefault(ID, Video.empty());
    }

}
