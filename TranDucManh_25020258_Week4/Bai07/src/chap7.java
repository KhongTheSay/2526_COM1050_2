package TranDucManh_25020258_Week4.Bai07.src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    private String id ;
    private String name ;
    private  double gpa ;
    public Student (String id ,String name , double gpa ){
        this.id = id;
        this.name = name ;
        this.gpa = gpa ;
        
    }
    public void getId(String id){
        this.id = id ;
    }
    public String setId( ){
        return id ;
    }
    public void setGpa(double gpa){
        this.gpa = gpa  ;
    } 
    public double getGpa( ){
        return gpa ;
    }
    public void setName(String name){
        this.name = name ;
    }
    public String getName ( ){
        return name ;
    }
    public void infor (){
        System.out.println(name + " " + id + " " + gpa ) ;
    }

}
@FunctionalInterface  // chỉ có một phương thức trừu tượng duy nhất để đảm bảo tính hợp lệ của lambda expression
interface  Operation<T> {
    T execute(T a , T b );
}

public class chap7 {
    public static void main ( String [] args ){
        Student x = new Student("S01", "DucManh ", 9.9);
        Student y = new Student("S02", "Zalo", 3.2);
        Student c = new Student("S03","Insta ",6.3 );
        Student d = new Student("S04","Vscode ",5.3);

        List<Student> list = new ArrayList<>();
        list.addAll(List.of(x,y,c,d));

        list.removeIf(Student -> Student.getGpa() < 5.0);
        for ( Student stu : list){
            stu.infor();
        }
        System.out.println("_______________________");
        list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        list.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));
        // Collections.sort(list, (s1,s2) -> s1.getName().compareTo(s2.getName()));
        for ( Student stu : list){
            stu.infor();
        }
        System.out.println("_________________________");
        Operation<Double> cong = (a, b) -> a + b;
        // Operation<Double> tru = (a, b) -> a - b;
        // Operation<Double> nhan = (a, b) -> a * b;
        // Operation<Double> chia = (a, b) -> a / b;

        System.out.println("Cong hai so " + cong.execute(3.3, 2.3) );
    }
}