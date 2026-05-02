package TranDucManh_25020258_Week7.Bai10.src;

class Worker implements Runnable {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
        }
    }
}

public class chap10 {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        
        t.start();

        try {
            Thread.sleep(1);
            worker.stop();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hoan Thanh In");
    }
}