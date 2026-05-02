package TranDucManh_25020258_Week5.Bai09.src;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner ;


class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String id , name ;
    Double gpa ;
    public Student (String name , String id , Double gpa ){
        this.name = name ;
        this.id = id ; 
        this.gpa = gpa ;
    }
}
class List {
    ArrayList<Student> list = new ArrayList<>(); 
    public void add(Student B ){
        list.add(B);
    }
}

public class chap9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // sc.nextLine();

        String target = sc.nextLine();
        // sc.nextLine();

        ObjectOutputStream in = null ;
        ObjectInputStream out = null ; 
        Student hs  = null ; 

        try {
            in = new ObjectOutputStream( new FileOutputStream(target));      
            while (true ){
                String name = sc.nextLine();
                if (name.equals("END")){ break ;}
                Double  gpa = sc.nextDouble();
                sc.nextLine();
                String id = sc.nextLine();
                Student sv = new Student(name, id, gpa);
                in.writeObject(sv);                
            }
            } catch (EOFException e ){
                System.out.println("Doneee");
            } catch (FileNotFoundException e  ){
                System.out.print("File nay khong ton tai");
            } catch (IOException e  ){
                System.out.println("Loi IO");
            }
        
        try {
            out = new ObjectInputStream( new FileInputStream(target));
            while (true ){
                hs = (Student) out.readObject();
                System.out.println(hs.name);                
            }
            } catch (EOFException e ){
                System.out.println("Loi EOF");
            } catch (ClassNotFoundException e ){
                System.out.println("Khong tim thay lop ");
            } catch (FileNotFoundException e  ){
                System.out.print("File nay khong ton tai");
            } catch (IOException e  ){
                System.out.println("Loi IO");
                e.printStackTrace();
            }      
        sc.close();
    }
}
