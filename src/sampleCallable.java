import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class sampleCallable implements Callable<Integer> {

    public int id;

    public sampleCallable(int id) {
        this.id = id;
    }

    public Integer call() throws Exception {
        Random rng = new Random();
        Thread.sleep(rng.nextInt(100) + 101);
        Integer numToSquare = rng.nextInt(30) + 1;
        System.out.println("Thread-" + this.id + " calculating square of " + numToSquare);
        numToSquare *= numToSquare;
        return numToSquare;
    }
}
