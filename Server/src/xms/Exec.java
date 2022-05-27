package xms;

public class Exec {

    public static void main (String[] args) throws Exception {

        ReDo(args);
    }


    private static void ReDo (String[] args) throws Exception {

        try {

            Main.main(args);

        } catch (Exception e) {
            e.printStackTrace();
            ReDo(args);
        }
    }


}
