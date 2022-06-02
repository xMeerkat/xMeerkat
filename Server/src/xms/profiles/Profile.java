/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.profiles;

import org.jetbrains.annotations.NotNull;
import xms.MAPS;
import xms.internal.AbstractResponse;
import xms.internal.Request;
import xms.internal.Response;
import xms.website.profile.ProfilePage;

import java.net.URI;
import java.util.UUID;

public class Profile {

    /**
     * Username of the person
     */
    public final @NotNull String username;

    /**
     * Name of the person
     */
    public final @NotNull String name;

    /**
     * Account type
     */
    public final @NotNull AccType accType;

    /**
     * Bio of the person
     */
    public final @NotNull String bio;

    /**
     * Person's ID
     */
    public final @NotNull String ID;

    /**
     * URI to the person's profile picture
     */
    public final @NotNull URI profilePicture;



    public Profile (@NotNull String username, @NotNull String name, @NotNull AccType accType, @NotNull String bio, @NotNull String ID, @NotNull String profilePicture, @NotNull Boolean ghost) {

        // Username Length must not be more than 30 characters
        if (username.length() > 30) {
            this.username = username.substring(0, 30);
        } else {
            this.username = username;
        }


        // DisplayName Length must not be more than 40 characters
        if (name.length() > 40) {
            this.name = name.substring(0, 40);
        } else {
            this.name = name;
        }


        this.accType = accType;


        // Bio Length must not be more than 1000 characters
        if (bio.length() > 1000) {
            this.bio = bio.substring(0, 1000);
        } else {
            this.bio = bio;
        }


        // Profile ID must be 8 chars
        if (ID.length() == 8) {
            this.ID = ID;
        } else {
            this.ID = UUID.randomUUID().toString().substring(0, 8);
        }


        this.profilePicture = URI.create(profilePicture);


        if (!ghost) {
            ProfileMap.profiles.put(this.ID, this);
            ProfileMapN.profiles.put(this.username, this);
            ProfileList.profiles.add(this);
        }
    }


    public void Push () {
        MAPS.getMappings().addMap("GET", "/user/" + this.username, new AbstractResponse() {

            @Override
            public Response getResponse(Request req) {
                return ProfilePage.response(Profile.this);
            }
        });

        MAPS.getMappings().addMap("GET", "/user/&" + this.ID, new AbstractResponse() {

            @Override
            public Response getResponse(Request req) {
                return ProfilePage.response(Profile.this);
            }
        });
    }


    public static @NotNull Profile empty () {
        return new Profile("Placeholder", "xMeerkat", AccType.NORMAL, "This account is a placehoder.", "b6a9a134", "", true);
    }
}
