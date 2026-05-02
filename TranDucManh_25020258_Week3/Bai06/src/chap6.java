package TranDucManh_25020258_Week3.Bai06.src;
import java.time.LocalDate;
import java.util.Scanner ;
abstract class Product {
    public String ma , ten  , name ;
    public double  giagoc ;
    public Product (String ma , String ten , double  giagoc , String name  ){
        this.ma = ma ;
        this.ten = ten ;
        this.giagoc = giagoc ;
    } 
    public double  getFinalprice(){
        return this.giagoc ;
    }
    abstract public String loaisp();

}

class Electronics extends Product {
    public int phibaohanh ;
    public Electronics (int phibaohanh , String ma , String ten , double  giagoc , String name ){
        super(ma , ten , giagoc , name  );
        this.phibaohanh = phibaohanh ;
    }
    @Override
    public double  getFinalprice(){
        return (double )(giagoc)* 1.1 + phibaohanh ; 
    }
    @Override
    public String loaisp(){
        return "Electronics";
    }
}

class Foods extends Product {
    private LocalDate hethan ;
    public Foods (LocalDate hethan ,String ma , String ten , double  giagoc , String name  ){
        super(ma,ten,giagoc , name  );
        this.hethan = hethan ;
    }
    @Override
    public double getFinalprice() {
        LocalDate today = LocalDate.now();
        LocalDate hancuoi = today.plusDays(7);
        if (hethan.isBefore(hancuoi)) {
            return giagoc  * 0.8;
        }
        
        return giagoc ;
    }
    @Override
    public String loaisp(){
        return "Foods";
    }

}


public class chap6 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Product [] sanpham = new Product[n];
        for ( int i = 0 ; i < n ; i++){
            String loaido =  sc.next();

            sc.findInLine("\"");
            String tensanpham = sc.findInLine("[^\"]+");
            sc.findInLine("\"");

            if (loaido.equals("E")){
                double giagoc = sc.nextDouble();
                int phibaohanh = sc.nextInt();

                sanpham[i] = new Electronics(phibaohanh, loaido, tensanpham, giagoc , null);   

            }
            else if ( loaido.equals("F")){
                double giagoc = sc.nextDouble();
                String hethan = sc.next();
                LocalDate hancuoi = LocalDate.parse(hethan);
                sanpham[i] = new Foods(hancuoi, loaido, tensanpham, giagoc , null);
            }
        } 
        sc.close();
        double total = 0;
        for ( Product sp : sanpham ){
            System.out.println(sp.ten + " - " + sp.loaisp() + sp.getFinalprice());
            total += sp.getFinalprice();
        }
        System.out.println("Tổng bill của bạn là " + total);
    }
}


// 3
// E "Laptop Dell" 1000 50
// F "Sữa tươi" 20 2026-03-20
// F "Bánh mì" 15 2026-04-10