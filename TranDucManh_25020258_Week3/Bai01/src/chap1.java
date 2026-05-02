
package TranDucManh_25020258_Week3.Bai01.src;
class Person {
    private String name , dob ;


    public Person (){
        System.out.println("1.Person is created ");
    }
    public Person(String name ){
        this.name = name ;

    }
}
class Employee extends Person {
    private double salary ; 
    public Employee (String name ){
        super(name);
        System.out.println("2. Employee is created");
    }
}
class Manager extends Employee {
    private String department ;
    public Manager (String name ){
        super(name);
        System.out.println("3.Manager is created");
    }
}
public class chap1 {
    public static void main(String[] args) {
        Manager manager = new Manager("John");
    }
}


// hàm super là hàm gọi đến constructor của lớp cha , nó phải được đặt ở dòng đầu tiên của constructor lớp con
// nếu lớp con không có constructor nào thì java sẽ tự động tạo ra một constructor mặc định và gọi đến constructor mặc định của lớp cha bằng hàm super() , nếu lớp cha không có constructor mặc định thì sẽ xảy ra lỗi biên dịch
// hàm super có ý nnghiax là gọi đến constructor của lớp cha để khởi tạo các thuộc tính và phương thức của lớp cha trước khi khởi tạo các thuộc tính và phương thức của lớp con
