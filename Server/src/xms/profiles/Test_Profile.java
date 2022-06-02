/*
 * Copyright (c) 2022, xMeerkat.com
 * All rights reserved.
 */

package xms.profiles;


public class Test_Profile {




    public static void addProfiles () {


        new Profile("xMeerkat",
                    "xMeerkat",
                    AccType.VERIFIED_DOMAIN_OWNER,
                    "Free meerkat videos!",
                    "07f39117",
                    "https://raw.githubusercontent.com/xMeerkat/official-assets/master/assets/LOGO.png"
        ).Push();


        new Profile("gemsvido",
                "gemsvidø",
                AccType.VERIFIED_MODERATOR,
                "Owner of xMeerkat",
                "cb17a326",
                "https://pbs.twimg.com/profile_images/1484971677549142016/J42seFVQ_400x400.png"
        ).Push();

        new Profile("critical",
                "_CriticalHit",
                AccType.VERIFIED_MODERATOR,
                "Co-Owner of xMeerkat",
                "41f9a33c",
                "https://i.imgur.com/REVWbb5.png"
        ).Push();


        new Profile("delgado",
                "David Delgado",
                AccType.VERIFIED_ACCOUNT,
                "I love Meerkats! I also love to have sex with meerkats!",
                "b572ddc8",
                "https://i.imgur.com/9GCXFD6.png"
        ).Push();



        generatedProfiles();


    }


    private static void generatedProfiles () {

        new Profile("cliplab",
                "CLIPLAB",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/dDIuQyE64Wg",
                "2098bcb1",
                "https://yt3.ggpht.com/ytc/AKedOLRiCvlBstKOBWgKoCPngiYpqn-h5AbYTJPd4wnc=s88-c-k-c0x00ffffff-no-rj"
        ).Push();


        new Profile("smolar",
                "Alex Smolar",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/TekLgOCE8DA",
                "483b2132",
                "https://yt3.ggpht.com/ytc/AKedOLRbunI5Twq74xYN2cDY2wFdMKYz2sWlqCk2AwULyuk=s88-c-k-c0x00ffffff-no-rj"
        ).Push();



        new Profile("kevlar",
                "Kev Lar",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/MLJsnacoUs4",
                "2070202c",
                "https://yt3.ggpht.com/ytc/AKedOLS1a6bumsClEhEGaxKFodO_LbJWcdPRolfQLwk-=s88-c-k-c0x00ffffff-no-rj"
        ).Push();



        new Profile("findlay",
                "Rosetta Findlay",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/fwgIh3pPslI",
                "e246c9bc",
                "https://yt3.ggpht.com/ytc/AKedOLQTmlZWUABPjsGJrIOqFGLGBBOzU9mottqBdQ=s88-c-k-c0x00ffffff-no-rj"
        ).Push();

    }

}
