package TranDucManh_25020258_Week6.Bai11.src;

import java.util.ArrayList;
import java.util.Arrays;

class ReportTemplate implements Cloneable  {
    public String title , footer ;
    ArrayList<String> list = new ArrayList<>();

    public ReportTemplate ( String title , String footer , ArrayList<String> list ) {
        this.footer = footer ;
        this.title = title ;
        this.list = list;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void show() {
        System.out.println("Title " + title + "Footer : " + footer + "List : " + list );
    }

}

public class chap11 {
    public static void main(String[] args) {
        try{
        ReportTemplate a = new ReportTemplate("Manh", "OKOKKKOKOKOKOK",new ArrayList<>(Arrays.asList("bc", "cde")) );
        ReportTemplate b = (ReportTemplate) a.clone();
        ReportTemplate c = (ReportTemplate) b.clone();
        a.show();
        c.show();
        b.show();            
        } catch (CloneNotSupportedException e){
            System.out.println("Loi khong sao chep duọc");
        }


    }
}
