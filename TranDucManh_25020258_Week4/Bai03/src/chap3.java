package TranDucManh_25020258_Week4.Bai03.src;

import java.util.Scanner ;


interface IWorkable {
    void work();
}
abstract class Employee implements IWorkable {
    protected  String id , name ;
    protected   double baseSalary ;
    public Employee (String id , String name , double  baseSalary){
        this.id = id ; 
        this.name = name ;
        this.baseSalary = baseSalary;
    }
    public abstract double calculatePay();
    @Override
    public void work(){
        System.out.println("work cua lop cha ");
    }
    public abstract void  infor ();
}
class OfficeWorker  extends Employee   {
    public OfficeWorker (String id , String name ,  double baseSalary){
        super(id , name , baseSalary);
    }
    @Override
    public double calculatePay(){
        return baseSalary ;
    }
    @Override
    public void work (){
        System.out.println("Soan thao van ban ");
    }
    @Override
    public void infor(){
        System.out.println(name + " - Pay : " + calculatePay() );
        work();
    }
    
}
class Technician extends Employee {
    protected int  overtimeHours ;
    public Technician (String id , String name ,  double baseSalary , int overtimeHours ){
        super (id , name , baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public double calculatePay(){
        return baseSalary + overtimeHours*20000;
    }
    @Override
    public void work(){
        System.out.println("Lap dat thiet bi");
    }
    @Override
    public void infor(){
        System.out.println(name + " - Pay : " + calculatePay() );
        work();
    }

}
public class chap3 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Employee [] list = new Employee[n];

        for ( int i = 0 ; i < n ; i++){
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            Double baseSalary = sc.nextDouble();
            // sc.nextLine();

            if (type.equals("O")){
                list[i] = new OfficeWorker(id, name, baseSalary); 
            }
            else if (  type.equals("T")){
                int overtimeHours = sc.nextInt();
                list[i] = new Technician(id, name, baseSalary, overtimeHours);
            }
        }
        sc.close();

        for ( Employee nv : list ){
            nv.infor();
        }


    }
}