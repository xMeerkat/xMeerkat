/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.profiles;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/** Profile map by usernames */
public final @NotNull class ProfileMapN {

    public static final @NotNull HashMap<String, Profile> profiles = new HashMap<>();

    public static Profile get (String username) {
        return profiles.getOrDefault(username, Profile.empty());
    }

}
