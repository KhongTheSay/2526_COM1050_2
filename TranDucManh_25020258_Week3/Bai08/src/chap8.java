package TranDucManh_25020258_Week3.Bai08.src;
import java.util.Scanner ;
abstract class Robot {
    private int id , batteryLevel ;
    public String ModelName ;
    public Robot (int id , String ModelName){
        this.id = id ;
        this.ModelName = ModelName ;
    }
    public void chargeBattery(){
        this.batteryLevel =100;
    }

    public final void showIdentity(){
        System.out.println("ID : " + id + " Model :" + ModelName );
    }
    abstract public void PerformMainTask();
    abstract public void show();
}
interface Flyable  {void fly();}
interface Swimmable  {void swim();}
interface GPS  {void getCoordinates();}


interface ElectronicDevice{
    void turnOn();
}



class DroneRobot extends Robot implements Flyable , GPS , ElectronicDevice {
    public DroneRobot (int id , String ModelName ){
        super(id, ModelName );
    }
    @Override
    public void fly(){ System.out.println("DroneRobot có thể bay");}
    @Override
    public void getCoordinates(){ System.out.println("DroneRobot có toa do");}
    @Override
    public void PerformMainTask(){
        System.out.println("Robot giao hàng ");
    }
    @Override
    public void turnOn(){
        System.out.println("robot da duoc bat ");
    }
    public void show(){
        System.out.println(ModelName + " co the bay");
        System.out.println(ModelName + " co toa do ");
        System.out.println(ModelName + " Robot giao hang  ");
    }
}

class FishRobot extends Robot implements Swimmable {
    public FishRobot (int id , String ModelName ){
        super(id, ModelName );
    }
    @Override
    public void swim(){ System.out.println("FishRobot có thể bơi");}
    @Override
    public void PerformMainTask(){
        System.out.println("Robot dười nước ");
    }
    public void show(){
        System.out.println(ModelName + " co the boi");
        System.out.println(ModelName + " Robot duoi nuoc ");
    }
}

class  AmphibiousRobot extends Robot implements Flyable , GPS , Swimmable {
    public  AmphibiousRobot (int id , String ModelName ){
        super(id, ModelName );
    }
    @Override
    public void fly(){ System.out.println("AmphibiousRobotcó thể bay");}
    @Override
    public void getCoordinates(){ System.out.println("AmphibiousRobot có toa do");}
    @Override
    public void swim(){ System.out.println("AmphibiousRobot có thể bơi");}
    @Override
    public void PerformMainTask(){
        System.out.println("Robot đa năng  ");
    }
        public void show(){
        System.out.println(ModelName + " co the bay");
        System.out.println(ModelName + " co the boi");
        System.out.println(ModelName + " co toa do");
        System.out.println(ModelName + " Robot duoi nuoc ");
    }
}

public class chap8 {
    public static void main (String [] args ){
        Scanner sc = new Scanner(System.in);

        Robot [] listrobot = new Robot[3];
        listrobot[0] = new AmphibiousRobot(17,"A-Robot");
        listrobot[1] = new FishRobot(18, "F-Robot");
        listrobot[2] = new DroneRobot(19, "D-Robot");

        for ( Robot rb : listrobot ){
            rb.PerformMainTask();
        }
        // listrobot[2].fly();
        ((DroneRobot) listrobot[2]).fly();
        ((FishRobot)  listrobot[1]).swim();
        ((AmphibiousRobot) listrobot[0]).fly();
        // int n = sc.nextInt();
        // sc.nextLine();
        // if ( listrobot[n] instanceof Flyable){
        //     if (n==0){
        //         ((AmphibiousRobot) listrobot[0]).fly();
        //     }
        //     else if (n==2){
        //         ((DroneRobot) listrobot[2]).fly();
        //     }
        // }
        // else {
        //     System.out.println("Robot khong the bay");
        // }




        System.out.println("__________________________________________________");
        int m = sc.nextInt();
        sc.nextLine();
        Robot [] rb = new Robot[m];
        for ( int i = 0 ; i < m ; i++){
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();
            sc.nextLine();


            if (type.equals("DR")){
                rb[i] = new DroneRobot(id, name);
            }
            else if (type.equals("FR")){
                rb[i] = new FishRobot(id, name);
            }
            else if (type.equals("AR")){
                rb[i] = new AmphibiousRobot(id, name);
            }
        }
        for ( Robot rbs : rb ){
            rbs.PerformMainTask();
            if ( rbs instanceof Flyable){
                ((Flyable) rbs).fly();
            }
            if (rbs instanceof Swimmable){
                ((Swimmable) rbs).swim();
            }
            if ( rbs instanceof GPS){
                ((GPS) rbs).getCoordinates();
            }
    }
}
}


// 0
// 3
// DR 1 D1
// FR 2 F1
// AR 3 A1