package TranDucManh_25020258_Week8.Bai01.src;

class Calculator {
    private static final double DISCOUNT = 0.9;

    public double calculate(int hours, double rate, boolean member) {
        double fee = hours * rate;
        if (member) {
            fee *= DISCOUNT;
        }
        return fee;
    }
}



abstract class Area{
    double a, b;
    Area(double a, double b) { this.a = a; this.b = b; }
    abstract double getArea();
}
class Triangle extends Area{
    Triangle(double a, double b) { super(a, b); }
    @Override
    double getArea(){ return a*b*0.5;}
}
class Rectangle extends Area{
    Rectangle(double a, double b) { super(a, b); }
    @Override
    double getArea(){ return a*b;}
}
class Circle extends Area{
    Circle(double a) { super(a, 0); }
    @Override
    double getArea(){ return 3.141569*a*a;}
}
class Other extends Area {
    Other(double a, double b) { super(a, b); }

    @Override
    double getArea() {
        return -1;
    }
}



class user{
    private String title ;
    private String content ;
}
class inforuser{
    private String authorEmail ;
    private String authorName ;
    private String authorPhone ;
    private String authorAdress;
}



class information{
    public user finbyId(int id ){
        return new user();
    }
}
class sendInfor{
    public void sendWelcomeEmail(user user ){}
    public void  sendPasswordResetEmail(user user){}
}
class display{
    public void renderUserProfile(user user){}
}
class export {
    public String  exportUserToCsv(user user){
        return "";
    
    }
}




public class chap1 {
    public static void main(String[] args) {
        System.out.println("Hello from chap1");
    }
}
