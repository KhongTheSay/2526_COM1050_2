package TranDucManh_25020258_Week7.Bai09.src;

import java.util.concurrent.locks.ReentrantLock;
class Counter {
     int value =0;
    ReentrantLock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }
    public void tryIncrement() {
        if (lock.tryLock()) {
            try {
                value++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": Khong lay duoc lock");
        }
    }
}
public class chap9 {
    public static void main(String[] args) {
        Counter cnt = new Counter();
        Thread[] thrds = new Thread[4];
        for ( int i =0;i<4;i++){
            thrds[i] = new Thread(()->{
                for ( int j=0;j<10000;j++){
                    cnt.tryIncrement();
                }
            });
            thrds[i].start();
        }
        try {
            for (Thread t : thrds) t.join();
            System.out.println("Final Value: " + cnt.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
