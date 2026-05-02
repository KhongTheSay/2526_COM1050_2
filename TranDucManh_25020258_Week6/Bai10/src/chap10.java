package TranDucManh_25020258_Week6.Bai10.src;



class Logger {
    private static  Logger instance = null ; 
    private Logger (){}
    public  static Logger getInstance (){{
        if ( instance == null ){
            instance = new Logger();
        }
        return instance ;
    }}
    void logInfo(String msg ){
        System.out.println("[INFO]" + msg);
    }
    void logError(String msg){
        System.out.println("[ERROR]" + msg );
    }
}
public class chap10 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Logger instances equal: " + (logger1 == logger2));

        
        logger1.logInfo("Application started");
        logger2.logInfo("Processing data...");
        logger1.logError("Something went wrong");
    }
}
