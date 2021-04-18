import java.util.Random;
public class sampleThread extends Thread {

    public void run() {
        Random rng = new Random();

        float sleepTime = rng.nextFloat();
        float printTime = sleepTime * 1000;
        try {
            System.out.println(this.getName() + " is sleeping for " + (int) printTime  + " milliseconds.");
            sleep((long)sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
