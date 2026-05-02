package TranDucManh_25020258_Week3.Bai09.src;
import java.util.Scanner ;

interface IPayable {
    public double getPaymentAccount ();
}

abstract class Staff implements IPayable  {
    public String name , id;
    public Staff(String name , String id){
        this.name = name ;
        this.id = id ;
    }
    public void setname(String name ){
        this.name = name ;
    }
    public void setid (String id ){
        this.id = id ;
    }
    public String  getname (){
        return this.name ;
    }
    public String getid (){
        return this.id ;
    }
    abstract public double getPaymentAccount ();
}

class PartTimeStaff extends Staff {
    public int workingHours;
    public  double hourlyRate;
    public PartTimeStaff (int workingHours, double hourlyRate , String name , String id) {
        super(name , id );
        this.workingHours = workingHours;
        this.hourlyRate =hourlyRate  ;
    }
    @Override
    public double getPaymentAccount (){
        return  workingHours * hourlyRate ;
    }
    public String Loai(){
        return "PartTimeStaff ";
    }

}

class Invoice implements IPayable {
    public String itemname ;
    public int quantity ;
    public double pricePerItem ;
    public Invoice (String itemName, int quantity, double pricePerItem){
        this.itemname = itemname ;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem ;
    }
    @Override
    public double getPaymentAccount (){
        return quantity * pricePerItem;
    }
    public String Loai(){
        return "Invoice";
    }
    public String getname1(){
        return this.itemname;
    }


}


public class chap9{
    public static void main ( String [] args ){
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        IPayable [] payableList = new IPayable[n];

        for ( int i = 0 ; i < n ; i++){
            String type = sc.next();

            if (type.equals("S")){
                String id = sc.next();
                String name = sc.next();
                int workingHours = sc.nextInt();
                double hourlyRate = sc.nextDouble ();

                payableList[i] = new PartTimeStaff(workingHours, hourlyRate, name, id);
            }
            else if (type.equals("I")){
                String itemName = sc.next();
                int quantity = sc.nextInt();
                double pricePerItem = sc.nextDouble();

                payableList[i] = new Invoice(itemName, quantity, pricePerItem);

            }
        }
        sc.close();
        double  total = 0;
        for ( int i = 0 ; i < n ; i++){
            if (payableList[i] instanceof PartTimeStaff){
                PartTimeStaff staff = (PartTimeStaff) payableList[i];
                System.out.println(staff.Loai() + " " + staff.getname() + "- Payment :" + staff.getPaymentAccount() );
                total += staff.getPaymentAccount() ;
            }
            if (payableList[i] instanceof Invoice ){
                Invoice invoice = (Invoice) payableList[i];
                System.out.println(invoice.Loai() + " " + invoice.getname1()  + "Payment : " + invoice.getPaymentAccount());
                total += invoice.getPaymentAccount();
            
            }
        
        }
        System.out.println("Total Payment : " + total );
    }
}

//  