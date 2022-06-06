/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.premium;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/** Premium Token Storage */
public class pTokenStorage {


    private static String[] tokenList;



    private static void init () {

        File f = new File("private/premium_tokens.txt");
        String contents = null;

        try {
            contents = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
        } catch (Exception e) { e.printStackTrace();}

        if (contents == null) {
            throw new RuntimeException("Could not read premium tokens file");
        }

        String[] array = contents.split("\t");
        System.out.println(Arrays.toString(array));

        tokenList = array;


    }

    public static void xin () {
        init();
    }


    public static @NotNull Boolean isValidToken (@NotNull String token) {

        if (token.equals("")) {
            return false;
        }

        for (String t : tokenList) {
            if (t.replaceAll("\n", "").trim().equals(token)) {
                return true;
            }
        }

        return false;
    }


}