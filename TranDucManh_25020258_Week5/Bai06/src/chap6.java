package TranDucManh_25020258_Week5.Bai06.src;


import java.lang.Exception ;
import java.util.InputMismatchException;
import java.util.Scanner ;


public class chap6 {
    public static float chia(int tu , int mau ) throws Exception {
        if (mau ==0 ){
            throw new ArithmeticException();
        }
        else {
            return tu / mau ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0 , b = 0 ;
        boolean check =  true ;
        while (check){
            try {
            a = sc.nextInt();
            sc.nextLine();
            b = sc.nextInt();
            check = false ;
            } catch  ( InputMismatchException e ) {
                System.out.println("Hay nhap so nguyen ");
                sc.nextLine();
            }            
        }
        try {
            System.out.println(chia(a,b));
        } catch ( Exception e ){
            System.err.println("Loi vi chia cho 0  roi ");
        }
        finally {
            System.out.println("Hoan thanh chuong trinh ");
        }
    }
}
