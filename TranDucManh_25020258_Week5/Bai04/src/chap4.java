package TranDucManh_25020258_Week5.Bai04.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class WordCounter {
    public static String xuly(String text  ){
        for ( int i = 0 ; i < text.length() ; i++ ){
            char a = text.charAt(i);
            if ( a== '?' ||  a=='.' || a ==','){
                text = text.replace(String.valueOf(a),"");
            }
            if ( Character.isUpperCase(a)){
                text = text.replace(a,Character.toLowerCase(a));
            }
        }
        return text ;
    }
}


public class chap4 {
    public static  void displayResult(HashMap<String,Integer> map){
        int m = Collections.max(map.values());
        map.forEach((word, count) -> {
            if (count == m) {
                System.out.println("Most frequent word is :  "+ word );
            }
        });
    }
    public static void main(String[] args) {
        String text = "Hello world. This is a java program. Hello java, hello world.";     
        text += "helo";   
        WordCounter sc = new WordCounter();

        String ans = WordCounter.xuly(text);
        System.out.println(ans);

        String[] words = ans.split("\\s+");
        ArrayList<String> lits = new ArrayList<>(Arrays.asList(words));

        HashMap<String,Integer> map = new HashMap<>();
        for (String w : words ){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        displayResult(map);
    }
}



// if (map.containsKey(word)){
//     int cnt = map.get(word);  //
//     map.put(word, cnt + 1);
// }
// else {
//     map.put(word, 1);
// }



// ArrayList<String> dsLop = new ArrayList<>();
// dsLop.add("Manh");
// dsLop.add("Vinh");

// if (dsLop.contains("Manh")) {
//     System.out.println("Có người đẹp trai trong lớp!");
// }