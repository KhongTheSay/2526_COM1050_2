package TranDucManh_25020258_Week6.Bai07.src;

interface Notifier {
    void send(String msg );
}

class EmailNotifier  implements Notifier {
    @Override
    public void send(String msg){
        System.out.println("Email SENDDD " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier n;
    public NotifierDecorator(Notifier n) {
        this.n = n;
    }
    @Override
    public void send(String message) {
        n.send(message);
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier n) {
        super(n);
    }

    private void notifySMS(String message) {
        System.out.println(" Gửi SMS: " + message);
    }

    @Override
    public void send(String message) {
        super.send(message);
        notifySMS(message);
    }
}


class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier n) {
        super(n);
    }
    private void FacebookNoti(String message) {
        System.out.println(" FacebookNotifier " + message);
    }
    @Override
    public void send(String message) {
        super.send(message);
        FacebookNoti(message);
    }
}


public class chap7 {
    public static void main(String[] args) {
        Notifier system = new EmailNotifier();
        system = new FacebookNotifier(system);
        system = new SMSNotifier(system);
        system.send("Heloo");   

        Notifier simpleSystem = new SMSNotifier(new EmailNotifier());
        simpleSystem.send("Tin nhắn");
        
    }
}
