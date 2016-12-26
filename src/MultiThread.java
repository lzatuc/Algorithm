import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by li on 2016/12/21.
 */
public class MultiThread
{
    public static void main (String args[]) throws ExecutionException, InterruptedException
    {
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//
//        int num[] = {610849, 611189, 611557, 611939,
//                     610867, 611207, 611561, 611951,
//                     610877, 611213, 611587, 611953};
//
//        int total = 0;
//
//        double t1 = System.currentTimeMillis();
//
//        for (int i = 0; i < num.length; i++) {
//            if (isPrime(num[i])) {
//                total++;
//            }
//        }
//
//        double t2 = System.currentTimeMillis();
//
//        System.out.println("my total = " + total);
//        System.out.println("my time = " + (t2 - t1));
//        List<Future<Boolean>> futures = new ArrayList<>();
//        for (int i = 0; i < num.length; i++) {
//            final int j = i;
//            futures.add(executor.submit(() -> isPrime(num[j])));
//        }
//        total = 0;
//        for (Future<Boolean> future : futures) {
//            if (future.get().equals(Boolean.TRUE)) {
//                total++;
//            }
//        }
//
//        System.out.println("Total " + total);
//        System.out.println("Time " + (System.currentTimeMillis() - t2));

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            String str = executor.submit(() -> "this is a lamda function " + new Random().nextInt()).get();
            System.out.println(str);
        }
    }

    public static boolean isPrime (int x) throws InterruptedException
    {
        Thread.sleep(500);
        if (x < 1) {
            return false;
        }
        if (x == 2 || x == 3) {
            return true;
        }
        int sqrt = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
