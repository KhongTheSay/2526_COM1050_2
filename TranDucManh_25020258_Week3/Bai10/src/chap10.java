package TranDucManh_25020258_Week3.Bai10.src;
import java.util.ArrayList;
import java.util.Scanner ;




class Employee {
    public String name ; 
    public double Salary ;
    public Employee (String name , double Salary){
        this.name = name ;
        this.Salary = Salary;
    }
    public double calculateBonus(){
        return Salary * 0.1;
    }
    public String getname (){
        return this.name;
    }
    public double getSalary(){
        return this.Salary;
    }
    public void showInfo() {
        System.out.println(name + "  Salary: " + Salary);
    }
}
class Developer extends Employee{
    public int overtimeHours ;
    public Developer (int overtimeHours , String name , double Salary){
        super(name , Salary);
        this.overtimeHours = overtimeHours ;
    }
    @Override
    public double calculateBonus(){
        return 0.1 * Salary + (overtimeHours * 200000);
    }
    public int getOVT(){
        return this.overtimeHours;
    }
    @Override
    public void showInfo() {
        System.out.println(name + " | OVT: " + overtimeHours + " | Salary: " + Salary);
    }
}
class Tester extends Employee {
    public int bugsFound;
    public Tester (int bugsFound , String name , double Salary){
        super(name , Salary);
        this.bugsFound = bugsFound ;
    }
    @Override
    public double calculateBonus() {
        return 0.1* Salary + (bugsFound*50000);
    }
    public int getBugsF (){
        return this.bugsFound;
    }
    @Override
    public void showInfo() {
        System.out.println(name + " | Bugs: " + bugsFound + " | Salary: " + Salary);
}
}

public class chap10 {
    public static void main (String [] args ){
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Developer(10, "CongAn", 10000000));
        employeeList.add(new Developer(36, "DucManh", 150000000));
        employeeList.add(new Tester(10, "HaNam", 100000));
        employeeList.add(new Tester(36, "HaNam", 500000));
        employeeList.add(new Employee("Calm", 10000000));

        for (Employee nv : employeeList){
            nv.showInfo();
        }

        System.out.println("___________________________________________");


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee [] nv = new Employee[n];
        for ( int i =0 ; i < n ; i++){
            String type = sc.next();
            String name = sc.next();
            Double Salary = sc.nextDouble();

            if (type.equals("D")){
                int overtimeHours = sc.nextInt();
                nv[i] = new Developer(overtimeHours, name, Salary);
            }
            else if (type.equals("T")){
                int bugsFound = sc.nextInt();
                nv[i] = new Tester(bugsFound, name, Salary );
            }
            else if (type.equals("E")){
                nv[i] = new Employee(name, Salary);
            } 
        }
        for (Employee peo : nv) {
            if (peo instanceof Developer) {
                Developer dev = (Developer) peo; 
                System.out.println(dev.getname() +" Bonus : " + dev.getSalary());
                System.out.println("TANG KHOA HOC AWS");
            } 
            else if (peo instanceof Tester test) {
                System.out.println(test.getname() +" Bonus :  " + test.getSalary());
                System.out.println("TANG TOOL TEST ");
            } 
            else { 
                System.out.println(peo.getname() + " Bonus : " + peo.getSalary());
            }
}






    }
}


// 3
// D Minh 15000000 15
// T Lan 12000000 20
// E An 8000000
