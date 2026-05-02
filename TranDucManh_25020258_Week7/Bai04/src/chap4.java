package TranDucManh_25020258_Week7.Bai04.src;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;


class BookStore {
    Map<String,Integer> stock = new HashMap<>();
    public String name ;
    public int value ;
    public BookStore(String name , int value ){
        this.name = name ;
        this.value = value ;
    }

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public int getStock(String title) {
        readLock.lock(); 
        try {
            System.out.println("Đang đếm sách : " + title);
            return stock.getOrDefault(title,0);
        } finally {
            readLock.unlock();
        }
    }
    public void addBook(String title , int qty){
        writeLock.lock();
        try {
            System.out.println("Da them sach :" + title  );
            stock.put(title , stock.getOrDefault(title , 0) + qty);
        } finally {
            writeLock.unlock();
        }
    }
    public void borrow(String title , int qty ){
        writeLock.lock();
        try {
            int sl = stock.getOrDefault(title , 0);
            if (sl > qty ){
                System.out.println("Cho muon thanh cong ");
                stock.put(title , sl - qty);
            }
            else {
                System.out.println("Khong du so lương sach de mươn ");
            }
        } finally {
            writeLock.unlock();
        }
    }

}

public class chap4 {
    public static void main(String[] args) {
        BookStore st = new BookStore(null, 0);
        st.addBook("ONEPIECE", 9999);
        st.addBook("NARUTO", 2222);

        for ( int i = 0 ; i <3 ; i++ ){
            new Thread(() ->{
                int a = st.getStock("NARUTO");
                System.out.println("So luong sach nay la " + a );
            }).start();
        }
        new Thread(() ->{
                st.addBook("DRB",1000);
            }).start();
        new Thread(() ->{
                st.borrow("DRB",12);
            }).start();     
        
    }
}
