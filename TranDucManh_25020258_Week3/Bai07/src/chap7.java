package TranDucManh_25020258_Week3.Bai07.src;
import java.util.Scanner;

abstract class Hotel {
    public int sodem ;
    public Hotel (int sodem ){
        this.sodem = sodem ;
    }
    abstract public double  giatien ( );
    abstract public String loaiphong();
}
class Standard extends Hotel{
    public Standard (int sodem ){
        super(sodem);
    }
    @Override
    public double  giatien(){
        if ( sodem > 3){
            return (double ) 500000 * sodem * 0.95;
        }
        else {
            return 500000 * sodem ;
        }

    }
    @Override
    public String loaiphong(){
        return "Phong Standard ";
    }
}

class VIP extends Hotel {
    public VIP (int sodem ){
        super (sodem );
    }
    @Override
    public double  giatien (){
        return sodem * 2000000 ; 
    }
        @Override
    public String loaiphong(){
        return "Phong VIP ";
    }
}

public class chap7 {
    public static void main ( String [] args ){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Hotel [] bills = new Hotel[n] ;
        for ( int i = 0 ; i < n ; i++){
            String loaiphong = sc.next();

            if (loaiphong.equals("V")){
                int sodem = sc.nextInt();
                bills[i] = new VIP(sodem);
            }
            else if (loaiphong.equals("S")){
                int sodem = sc.nextInt();
                bills[i] = new Standard(sodem);                
            }
        }
        sc.close();
        double total = 0 ;
        for ( Hotel bill : bills ){
            System.out.println("Quy khac o phong " + bill.loaiphong() + " trong  "+ bill.sodem + "dem can thanh toan " + bill.giatien() );
            total += bill.giatien();
        }
        System.out.println("Tong tien cua quy khach la " + total);
    }
}

// 3
// V 2
// S 2
// V 1