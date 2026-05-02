package TranDucManh_25020258_Week5.Bai10.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class InValidConfigEX extends Exception {
    public InValidConfigEX (String message ){
        super("Errorrrrr : " + message);   
    }
}

class vuive extends Exception {
    public vuive  (String message ){
        super( message);
    }
}
public class chap10 {
    public static void kiemtra(Map<String,String> list ) throws InValidConfigEX {
        if ( !list.containsKey("username")){
            throw new InValidConfigEX("Missing name ");
        }
        if ( !list.containsKey("timeout")){
            throw new InValidConfigEX("missing timout");
        }
        int timeout = Integer.parseInt(list.get("timeout"));
        if (timeout <= 0) throw new InValidConfigEX("timeout must be > 0");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();

        Map<String, String> list = new HashMap<>();
        BufferedReader reader = null;


        try {
             reader = new BufferedReader(new FileReader(source));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || !line.contains("=")) continue;
                String [] words = line.split("=", 2);
                // 
                if (words.length == 2  ){
                    list.put(words[0],words[1]);
                }
            }
            kiemtra(list);
            list.forEach((k, v) -> {
                System.out.println(k + " = " + v);
            });
            System.out.println("Config loaded successfully.");       
        } catch (FileNotFoundException e) {
            System.err.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        } catch (InValidConfigEX e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Program finished.");
        }
        sc.close();
    }
}