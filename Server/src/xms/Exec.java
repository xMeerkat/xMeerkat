package xms;

public class Exec {

    public static void main (String[] args) throws Exception {

        Thread proc = new Thread(() -> {
            Main.main(args);
        });

        proc.start();


        while (true) {

           if (!proc.isAlive()) {
               proc.start();
           }

           Thread.sleep(10000);
        }

    }


}
