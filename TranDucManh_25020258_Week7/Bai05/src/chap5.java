package TranDucManh_25020258_Week7.Bai05.src;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner ;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


public class chap5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        sc.nextLine();

        List<Future<Boolean>> ans = new ArrayList<>();
        ExecutorService exe = Executors.newFixedThreadPool(m);
        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);


        for ( int i =0 ; i < m ; i++){
            final String id = sc.next();
            final long  processMs = sc.nextLong();
            sc.nextLine();
            Callable<Boolean> task =()->{
                System.out.println("Start" + id );
                Thread.sleep(processMs);
                Boolean check = true ;
                if (processMs > 1500){
                    check = true ;
                } else {
                    check = false ;
                }
                synchronized(logs){
                    if (check == true ){
                        logs.add("DONE " + id);
                        successCount.incrementAndGet();
                    } else {
                        logs.add("FAIL " + id );
                    }
                }
                return check ;
            };
            ans.add(exe.submit(task));
        for ( Future<Boolean> f : ans){
                try{
                    f.get();
                } catch ( InterruptedException  | ExecutionException e ){
                    e.printStackTrace();
                }
            }
        System.out.println("Success = " + successCount.get());
        for (String log : logs) {
                System.out.println(log);
            }
            
        }
        exe.shutdown();
    }
}
