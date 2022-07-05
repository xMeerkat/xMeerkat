/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import xms.website.LookingFor;

public final class Compiler {

    public static final @NotNull @Unmodifiable class Video {

        public static @NotNull String Compile (@NotNull xms.videos.Video video, @NotNull String html) {

            final StringBuilder out = new StringBuilder();
            String[] lines = html.split("\\n");

            out.append("<!-- Our software, xMeerkat, is open source at https://github.com/xMeerkat -->\n");


            for (String line : lines) {

                final String toReplace = line.replace("\n", "").replace("\t", "");

                if (toReplace.replace(" ", "").equals("")) {
                    continue;
                }
                else if (toReplace.startsWith("<!--") && toReplace.endsWith("-->")) {
                    continue;
                }
                else if (toReplace.startsWith("@java")) {
                    out.append(LookingFor.lf(toReplace, video));
                } else {
                    out.append(toReplace);
                }

            }



            return out.toString();
        }

    }

    public static final @NotNull @Unmodifiable class JSminifier {

        public static @NotNull String Compile (@NotNull String js) {

            final StringBuilder out = new StringBuilder();
            String[] lines = js.split("\\n");


            for (String line : lines) {

                final String toReplace = line.replace("\n", "").replace("\t", "");

                if ((toReplace.startsWith("/*") && toReplace.endsWith("*/")) || (toReplace.startsWith("//"))) {
                    continue;
                } else {
                    out.append(toReplace);
                }

            }



            return out.toString();
        }

    }

    public static final @NotNull @Unmodifiable class CSSminifier {

        public static @NotNull String Compile (@NotNull String css) {

            final StringBuilder out = new StringBuilder();
            String[] lines = css.split("\\n");



            for (String line : lines) {

                final String toReplace = line.replace("\n", "").replace("\t", "");

                if ((toReplace.startsWith("/*") && toReplace.endsWith("*/"))) {
                    continue;
                } else {
                    out.append(toReplace);
                }

            }



            return out.toString();
        }

    }

}
