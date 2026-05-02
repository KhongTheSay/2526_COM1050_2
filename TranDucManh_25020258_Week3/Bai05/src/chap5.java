package TranDucManh_25020258_Week3.Bai05.src;
import java.util.Scanner;



abstract class Employee {
    public String name , MSNV , Birthday ;
    public Employee ( String name , String MSNV , String Birthday){
        this.name = name ;
        this.MSNV = MSNV ;
        this.Birthday = Birthday ;
    }
    abstract public double  LuongNhanVien();
    abstract public String Loainhanvien();
    public String getName(){
        return this.name ;
    }
    
}
class FullTimeEmployee extends Employee {
    public int basesalary , bonus , penalty ;
    public FullTimeEmployee (int basesalary , int bonus , int penalty,String name , String MSNV , String Birthday){
        super(name , MSNV , Birthday);
        this.basesalary = basesalary ;
        this.bonus = bonus ;
        this.penalty = penalty ;
    }
    @Override
    public double LuongNhanVien(){return basesalary +(bonus - penalty); }
    @Override
    public String Loainhanvien(){ return "FullTime";}
}
class PartTimeEmployee extends Employee {
    public int workingHours , hourlyRate;
    public PartTimeEmployee (int workingHours , int  hourlyRate ,String name , String MSNV , String Birthday ){
        super (name , MSNV , Birthday);
        this.workingHours = workingHours ;
        this.hourlyRate = hourlyRate ;
    }
    @Override
    public double LuongNhanVien(){return (workingHours * hourlyRate); }
    @Override
    public String Loainhanvien(){ return "PartTime ";}
    

}

public class chap5{
    public static void main ( String [] main ){
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Employee [] nhanvien = new Employee[n];
        
        for ( int i = 0 ; i < n ; i++){
            String loainhanvien = sc.next();
            sc.findInLine("\"");
            String name = sc.findInLine("[^\"]+");
            sc.findInLine("\"");

            if ( loainhanvien.equals("F")){
                int baseSalary = sc.nextInt();
                int bonus = sc.nextInt();
                int penalty = sc.nextInt();

                nhanvien[i] = new FullTimeEmployee(baseSalary, bonus, penalty, name, loainhanvien ,null );

            }
            else if (loainhanvien.equals("P")) {
                int workingHours  = sc.nextInt();
                int hourlyRate = sc.nextInt();

                nhanvien[i] = new PartTimeEmployee(workingHours, hourlyRate, name, loainhanvien ,null);


            }

        }
        sc.close();
        for (Employee nv : nhanvien){
            System.out.println("Teen Nhiên Viên là "+nv.name + " Loại Nhan Viên " + nv.Loainhanvien() + "  Có mức lương là "+ nv.LuongNhanVien());
        }

    }

}

// 3
// F "Nguyễn Văn A" 1500 200 50
// P "Trần Thị B" 80 10
// F "Lê Văn C" 1400 100 50

