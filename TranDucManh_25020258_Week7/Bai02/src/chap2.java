package TranDucManh_25020258_Week7.Bai02.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner ;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class chap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for ( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        int k = sc.nextInt();
        int l = n/k;

        ExecutorService exe = Executors.newFixedThreadPool(k);
        List<Future<Integer>> ans = new ArrayList<>();

        for ( int i = 0 ; i < k ; i++){
            int  a = i * l ;
            int b =0;
            if ( i!= k - 1 ){
                b = (i+1)*(l);
            } else {
                b = n ;
            }
            final int start = a ;
            final int end = b;
            Callable<Integer> task = () -> {
                int sum = 0 ;
                for ( int j = start ; j < end ; j++){
                    sum += arr[j];
                }
                return sum ;
            };
            ans.add(exe.submit(task));
        }
        int allsum = 0 ;
        try {
            for ( Future<Integer> f : ans){{
            allsum += f.get() ;
        }}
        } catch (InterruptedException  | ExecutionException e ){
            e.printStackTrace();
        }
        System.out.println(allsum);

        
    }
}
