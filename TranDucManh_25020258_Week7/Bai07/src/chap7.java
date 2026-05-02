package TranDucManh_25020258_Week7.Bai07.src;



import java.util.*;
import java.util.concurrent.*;

public class chap7 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt(); 

        ExecutorService exe = Executors.newFixedThreadPool(n);
        List<Future<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(); 
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }


            Callable<Integer> task = () -> {
                int count = 0;
                for (int x : arr) {
                    if (isPrime(x)) {
                        count++;
                    }
                }
                return count;
            };
            ans.add(exe.submit(task));
        }

        List<Integer> primeCounts = new ArrayList<>();
        int maxPrimes = -1;

        try {
            for (int i = 0; i < ans.size(); i++) {
                int count = ans.get(i).get();
                primeCounts.add(count);
                if (count > 0) {
                    System.out.println("Array " + i + ": " + count);
                } else {
                    System.out.println("Array " + i + ":");
                }
                if (count > maxPrimes) {
                    maxPrimes = count;
                }
            }
            if (maxPrimes >= 0) {
                for (int i = 0; i < primeCounts.size(); i++) {
                    if (primeCounts.get(i) == maxPrimes) {
                        System.out.println("Most primes: Array " + i + " with " + maxPrimes + " primes");
                    }
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            exe.shutdown();
        }
    }
}