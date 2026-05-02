public class chap1{
    public String str ="";
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
        long startTime = System.currentTimeMillis();
        useString();
        long endTime = System.currentTimeMillis();
        System.out.println("String的：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        useStringBuffer();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer：" + (endTime - startTime) + "ms");
    }
}