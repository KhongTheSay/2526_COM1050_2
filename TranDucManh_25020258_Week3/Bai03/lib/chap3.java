package TranDucManh_25020258_Week3.Bai03.lib;
class MathUtils {
    public int sum ( int a , int b ){
        return a + b ;
    }
}

class AdvancedMath extends MathUtils {
    @Override
    public int sum ( int a , int b ){
        return a + b + 10 ;
    }
    public  double   sum ( double a , double b){
        return (double)(a + b);
    }
}




public class chap3 {
    public static void main ( String [] args ){
        MathUtils m = new AdvancedMath();  // tham chiếu đến các phương thức của lớp MathUtils 
        System.out.println(m.sum(5, 5));
        // System.out.println(m.sum(5.5, 5.5));
       


    }
    
}
