package TranDucManh_25020258_Week7.Bai03.src;
class BankAccount {
    private long balance ;
    public BankAccount(long balance ){
        this.balance = balance ;
    } 
    public synchronized void withdraw(int amount ){
        if ( amount > 0 && amount < balance ){
            balance -= amount ;
            
        }
        else {
            System.out.println("So tien rut khong hop le");
        }
    }
    public synchronized void deposit (int amount ){
        balance += amount ;
        
    }
    public void infor(){
        System.out.println("So du tai khoan " + balance );
    }

}
public class chap3 {
    public static void main(String[] args) {
        BankAccount u1 = new BankAccount(9999909);
        BankAccount u2 = new BankAccount(100000);

        Thread t1 = new Thread(() ->{
            for ( int i = 0 ; i < 1000 ; i++){
                u1.deposit(100);
            }
        });
        Thread t2 = new Thread(() -> {
            for ( int i =0 ; i < 1000 ; i++){
                u2.withdraw( 100);   
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch ( InterruptedException e){
            e.printStackTrace();
        }
        u1.infor();
        u2.infor();


    }
}
