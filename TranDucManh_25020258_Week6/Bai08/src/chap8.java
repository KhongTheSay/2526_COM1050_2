package TranDucManh_25020258_Week6.Bai08.src;


class Report {
    public String title , content ;
    public Report (String title , String content ){
        this.title = title ;
        this.content = content ;
    }
    public String getTitle(){
        return this.title ;
    }
    public String getContent(){
        return this.content;
    }
}


interface ReportFormater{
    String format(Report data);
}
class JsonFormater implements ReportFormater {
    @Override
    public String format( Report data){
        return "JSON     Title :" + data.getTitle() + "Content :" + data.getTitle();   
    }
}
class XmlFormater implements ReportFormater {
    @Override
    public String format (Report data){
        return "XML      Title :" + data.getTitle() + "Content :" + data.getTitle();
    }
}
class ReportService {
    public ReportFormater  r ;
    public ReportService (ReportFormater  r){
        this.r = r ;
    }
    public void export(Report data){
        System.out.println(r.format(data));
    }
}


public class chap8 {
    public static void main(String[] args) {
        Report myReport = new Report("Chao buoi sang", "Sang nay phai di hc ");

        ReportService service = new ReportService(new JsonFormater());
        service.export(myReport);
    }
}
