package TranDucManh_25020258_Week5.Bai01.src;

public class chap1 {
    public String str ="";
    public int s ;
    public int sb ;
    public void useString(){
        for (int i = 0; i < 100000; i++) {
            str += "Hello";
        }
    }
    public void useStringBuffer(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
    }
    public void contentAnalysis (){
        String str ="d d d java d d. d d d   . d d d d d ? s java s s s s s ? d d d d đjdjdjd ? sjsjsiwiwjwj ?? djdjd djđ jajaj sjjjdjd ajajajd d jsjd jsjsjsjd iwoiwka f kabs  laJ FLA fA NF Ahd .  lẠ DL a f";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.' || c == '?' || c=='!') {
                s +=1 ;
            }
        }
        StringBuffer str2 = new StringBuffer();
        str2.append(" java ? java ? c++ ? python ! css ");
        for ( int i = 0 ; i < str2.length() ; i++){
            char b = str2.charAt(i);
            if (b == '.' || b == '?' || b=='!') {
                sb +=1 ;
            }
        }
        int idx = str2.indexOf("java"); 
        while (idx != -1) {  
            str2.replace(idx, idx + 4, "python");
            idx = str2.indexOf("java", idx + 6);
        }
        System.out.println("After : " + str2 );
    }
    public static void main(String[] args) {
        chap1 test = new chap1();
        
        long startTime = System.currentTimeMillis();
        test.useString();
        long endTime = System.currentTimeMillis();
        System.out.println("String" + ( endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        test.useStringBuffer();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (endTime - startTime) + "ms");

        test.contentAnalysis();
    }
}
