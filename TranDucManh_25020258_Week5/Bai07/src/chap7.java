package TranDucManh_25020258_Week5.Bai07.src;

import java.util.Scanner ;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class chap7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String target = sc.nextLine();
        BufferedReader reader = null ;
        PrintWriter writer = null ;
        int cnt =0;
        try {
            reader = new BufferedReader(new FileReader(source));
            writer = new PrintWriter(new FileWriter(target));
            String line ;
            System.out.println("ok");
            while ((line = reader.readLine()) != null ){
                writer.println(line);
                cnt++;
            }
            System.out.println("Da in xong ");
        } catch (FileNotFoundException e ){
            System.err.println("File khong ton tai");
        } catch (IOException e ){
            System.err.println("Loi IO error");
            e.printStackTrace();
        }
        finally {
            try {
               if ( reader != null ){reader.close();}
                if (writer != null ){ writer.close();} 
            } catch (IOException e ){
                System.err.println("Loi dong tep");
            }            
        }
        sc.close();
    } 
}
