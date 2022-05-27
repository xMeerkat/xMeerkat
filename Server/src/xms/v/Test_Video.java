package xms.v;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Test_Video {

    static List<String> tags = new ArrayList<>() {
        {
            add("tag1");
            add("tag2");
            add("tag3");
        }
    };

    public static final Video test = new Video("Sex Ed be like", "xMeerkat", "https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/ph_kids.mp4", "Ph Kids!", "Thu May 26 22:18:07 PDT 2022", UUID.randomUUID().toString(), tags);



}
