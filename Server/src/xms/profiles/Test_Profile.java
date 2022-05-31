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




        new Profile("AlexSmolar",
                "Alex Smolar",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/TekLgOCE8DA",
                "483b2132",
                "https://yt3.ggpht.com/ytc/AKedOLRbunI5Twq74xYN2cDY2wFdMKYz2sWlqCk2AwULyuk=s88-c-k-c0x00ffffff-no-rj"
        ).Push();



        new Profile("KevLar",
                "Kev Lar",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/MLJsnacoUs4",
                "2070202c",
                "https://yt3.ggpht.com/ytc/AKedOLS1a6bumsClEhEGaxKFodO_LbJWcdPRolfQLwk-=s88-c-k-c0x00ffffff-no-rj"
        ).Push();



        new Profile("RosettaFindlay",
                "Rosetta Findlay",
                AccType.GENERATED,
                "Profile from video: https://youtu.be/fwgIh3pPslI",
                "e246c9bc",
                "https://yt3.ggpht.com/ytc/AKedOLQTmlZWUABPjsGJrIOqFGLGBBOzU9mottqBdQ=s88-c-k-c0x00ffffff-no-rj"
        ).Push();



    }


}
