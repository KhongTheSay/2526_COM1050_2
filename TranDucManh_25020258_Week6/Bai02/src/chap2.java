package TranDucManh_25020258_Week6.Bai02.src;

interface Notification {
    void send(String msg );
}
class EmailNotifiCation implements Notification{
    @Override
    public void send(String msg ){
        System.out.println("Emai lNotifiCation");
    }
}
class SmsNotifiCation implements Notification {
    @Override
    public void send(String msg ){
        System.out.println("SMS notifi");
    }
} 

abstract class NotificationApp {
    public abstract  Notification createNotificationapp() ;
    public void tb ( String msg ){
        Notification tb = createNotificationapp();
        tb.send(msg);
    }
}


class EmailApp extends NotificationApp {
    @Override
    public Notification createNotificationapp (){
        return new EmailNotifiCation();
    } 
}
class SMSApp extends NotificationApp {
    @Override
    public Notification createNotificationapp(){
        return new SmsNotifiCation();
    }
}

public class chap2 {
    public static void main (String [] args ){
        NotificationApp app;

        app = new EmailApp();
        app.tb("Apppp1 thong bao ");

        app = new SMSApp();
        app.tb("App2 thong bao ");

    }
}