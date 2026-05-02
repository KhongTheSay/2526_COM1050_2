package TranDucManh_25020258_Week5.Bai08.src;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner ;


public class chap8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine()   ;
        int n = sc.nextInt();
        DataInputStream reader = null;
        DataOutputStream ghi = null;
        try {
            ghi = new DataOutputStream(new FileOutputStream(source));
            
            for ( int i = 0 ; i < n ; i++){
                ghi.writeInt(i);
            }
        } catch (IOException e){
            System.out.println("LOi IOE ");
            e.printStackTrace();
        }
        try {
            reader = new DataInputStream(( new FileInputStream(source)));
            while (true ){
                int num = reader.readInt();
                System.out.println(num);
            }

        } catch (EOFException e ){
            System.out.println("het du lieu - ngung doc ");
        } catch (FileNotFoundException e ){
            System.out.println("Khogn tim thay File ");
        } catch ( IOException e ){
            System.out.println("Loi IOE ;");
        }
        
        finally {
            try {
                if ( reader != null ){ reader.close();}
                if (ghi != null ){ ghi.close();}
            } catch (IOException e ){
                System.out.println("Khong the dong tep ");
            }

        }
        sc.close();

    }
}
