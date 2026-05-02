package TranDucManh_25020258_Week7.Bai06.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class chap6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ExecutorService exe = Executors.newFixedThreadPool(n);
        List<Future<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }

            final int index = i;
            final int maxv = Arrays.stream(arr).max().getAsInt();

            Callable<Integer> task = () -> {
                int second = -99999;
                boolean check = false;
                for (int j = 0; j < m; j++) {
                    if (arr[j] < maxv && arr[j] > second) {
                        second = arr[j];
                        check = true;
                    }
                }
                if (check) {
                    return second;
                } else {
                    return 0;
                }
            };
            ans.add(exe.submit(task));
        }

        int allsum = 0;
        try {
            for (int i = 0; i < ans.size(); i++) {
                Integer result = ans.get(i).get();
                if (result != 0) {
                    System.out.println("Array " + i + ": second largest = " + result);
                    allsum += result;
                } else {
                    System.out.println("Array " + i + ": Not found");
                }
            }
            System.out.println("Sum = " + allsum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            exe.shutdown();
        }
    }
}