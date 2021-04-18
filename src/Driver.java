import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws Exception{
        //create ES with 7 thread threadpool, create 50 sampleThreads, and submit them to ES
        ExecutorService ES = Executors.newFixedThreadPool(7); //creates an executorservice and instantiates a thread pool with 7 threads


        List <Future<?>> myFutures = new ArrayList<Future<?>>();
        for (int i = 0; i < 50; i++) {
            sampleThread temp = new sampleThread();

            Future <?> f = ES.submit(temp);
            myFutures.add(f);
        }
        System.out.println("Part A Output:\n******************\n");
        for (Future <?> currentFuture : myFutures) {
            currentFuture.get();
        }
        ES.shutdown();

        Future<Integer>[] callFutures = new Future[200];
        ExecutorService ESC = Executors.newCachedThreadPool();
        for(int i = 0; i < 200; i++) {
            sampleCallable temp = new sampleCallable(i);
            Future<Integer> f = ESC.submit(temp);
            callFutures[i] = f;
        }
        System.out.println("\nPart B Output:\n******************\n");
        for(int i = 0; i < 200; i++) {

            Integer temp = callFutures[i].get();
            System.out.println("Result from Thread-" + i + ": " + temp);
        }

        Thread.sleep(3000);
        ESC.shutdown();
        System.out.println("PROGRAM HAS FINISHED EXECUTING.");

    }
}
