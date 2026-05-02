package TranDucManh_25020258_Week7.Bai01.src;

class Task implements Runnable {
    public String name ; 
    public long durationMs ;
    public Task (String name , long durationMs ){
        this.name = name ;
        this.durationMs = durationMs ;
    }
    @Override
    public void run( ){{
        System.out.println("Start " + this.name);
        try {
            Thread.sleep(this.durationMs);
        } catch ( InterruptedException e ){{
            e.printStackTrace();
        }}
        System.out.println("End " + this.name);
    }}
}
public class chap1 {
    public static void main(String[] args) {
        Task t1 = new Task("Manh", 1999);
        Task t2 = new Task("ZALO", 999);

        Thread thrds1 = new Thread(t1);
        Thread thrds2 = new Thread(t2);

        thrds1.start();
        thrds2.start();
        try {
            thrds1.join();
            thrds2.join();
        } catch (InterruptedException e ){{
            e.printStackTrace();
        }}
        System.out.println("Done");
        
    }
}
