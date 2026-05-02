package TranDucManh_25020258_Week7.Bai08.src;

import java.util.*;
import java.util.concurrent.*;

public class chap8 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ExecutorService pool1 = Executors.newFixedThreadPool(n);
        ExecutorService pool2 = Executors.newFixedThreadPool(n);
        List<Future<Long>> ans2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) arr[j] = sc.nextInt();

            final int idx = i;
            Callable<List<Integer>> task1 = () -> {
                List<Integer> primes = new ArrayList<>();
                for (int x : arr) {
                    if (isPrime(x)) primes.add(x);
                }
                System.out.println("Stage 1 - Array " + idx + ": " + primes);
                return primes;
            };

            Future<List<Integer>> f1 = pool1.submit(task1);
            Callable<Long> task2 = () -> {
                List<Integer> data = f1.get(); 
                if (data.isEmpty()) return 0L;

                long res = 0;
                String type;
                if (data.size() % 2 == 0) {
                    type = "sum of squares";
                    for (int x : data) res += (long) x * x;
                } else {
                    type = "sum of cubes";
                    for (int x : data) res += (long) x * x * x;
                }
                System.out.println("Stage 2 - Array " + idx + ": " + type + " = " + res);
                return res;
            };
            ans2.add(pool2.submit(task2));
        }

        long total = 0;
        try {
            for (Future<Long> f : ans2) {
                total += f.get(); 
            }
            System.out.println("Total = " + total);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool1.shutdown();
            pool2.shutdown();
        }
    }
}
