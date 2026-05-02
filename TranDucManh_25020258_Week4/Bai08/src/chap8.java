package TranDucManh_25020258_Week4.Bai08.src;
import java.util.Scanner ;

interface dosang{
    void dosang(int m );
}
interface ketnoi{
    String ketnoi();
}
interface dolon{
    void dolon(int m );
}
interface Remote2 {
    String  Remote2();
}

abstract class Hours {
    public String ma , name , status ;
    public Hours (String ma , String name , String status ){
        this.ma = ma ;
        this.name = name;
        this.status = status ;
    }
    public String getname(){
        return name ;
    }
    public String Remote1(){
        return  name + " Turn Off";
    }
    public String getma(){
        return ma ;
    }

}
class Light extends Hours implements dosang {
    public int dosang1 ;
    public Light (String ma , String name , String status , int dosang ){
        super (ma , name , status );
        this.dosang1 = dosang1 ;
    }

    @Override
    public void dosang(int dosang1 ){
        this.dosang1 = dosang1 ;
    }
}
class MayLanh extends Hours implements ketnoi , Remote2{
    public MayLanh ( String ma , String name , String status ){
        super(ma , name , status );
    }
    @Override
    public String ketnoi(){
        return "MayLanh - Ket noi Wifii";
    }
    @Override
    public String Remote2(){
        return name + "connected  Wifi";
    }

}
class Loa extends Hours implements  ketnoi,dolon , Remote2{
    public int dolon1 ;
    public Loa ( String ma , String name , String status , int dolon1 ){
        super ( ma , name , status );
        this.dolon1 = dolon1 ;
    }
    @Override
    public String ketnoi(){
        return "Loa - Ket noi Wifii";
    }
    @Override
    public String Remote2(){
        return name + "Connected to Wifi";
    }
    @Override
    public void dolon(int dolon1 ){
        this.dolon1 = dolon1 ;
    }
}
class Rem extends Hours {
    public Rem (String ma , String name , String status ){
        super ( ma , name , status );
    }
}

public class chap8 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Hours [] list = new Hours[n];
        for ( int i = 0 ; i < n ; i++){
            String type = sc.next();
            String thutu = sc.next();
            String name = sc.next();
            if (type.equals("L")){
                list[i] = new Light(type, name, "Bat", 100);
            }
            else if (type.equals("AC")){
                list[i] = new MayLanh(type, name, "Bat");
            }
            else if (type.equals("S")){
                list[i] = new Loa(type, name, "Bat", 100);
            }
            else if (type.equals("C")){
                list[i] = new Rem(type, name, "Mo");
            }
        }
        sc.close();
        System.out.println("                   ");
        System.out.println("Turn off all Device :   ");
        for ( Hours a : list){
            if ( a!= null ){
                System.out.println(a.Remote1());
            }   
        }
        System.out.println("                  ");
        System.out.println("SetUp Wifi");
        for ( Hours a : list ){
            if (a instanceof Remote2 d){
                System.out.println(d.Remote2());
            }
        }

    }
}