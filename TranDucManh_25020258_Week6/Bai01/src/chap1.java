package TranDucManh_25020258_Week6.Bai01.src;


class AppConfig {
    private String appName , version , logLevel ;
    public AppConfig (String appName , String version , String logLevel ){{
        this.appName = appName ;
        this.version = version ;
        this.logLevel = logLevel ; 
    }}
    private static  AppConfig instance = null ; 
    private AppConfig (){}
    public static AppConfig getInstance (){{
        if ( instance == null ){
            instance = new AppConfig();
        }
        return instance ;
    }}
}
public class chap1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            AppConfig a = AppConfig.getInstance();
            System.out.println("HashCode: " + a.hashCode());
        });

        Thread t2 = new Thread(() -> {
            AppConfig b = AppConfig.getInstance();
            System.out.println("HashoCode2: "  + b.hashCode());
        });
        t1.start();
        t2.start();
    
}
}