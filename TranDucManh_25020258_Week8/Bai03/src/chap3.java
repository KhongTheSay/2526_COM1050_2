package TranDucManh_25020258_Week8.Bai03.src;
interface fuel {
    void refuel(double liters);
}
interface battery {
    void charge(int percent );
}

class  Vehicle {
    protected String plate;
    protected String brand;
    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }
    public String getInfor(){
        return "[" + plate + "] - " + brand;
    }
}
class MotorBike extends Vehicle implements fuel {
    private double fuelLevel ;
    public MotorBike(String plate , String brand , double fuelLevel ){
        super(plate,brand);
        this.fuelLevel = fuelLevel;
    }
    @Override
    public String getInfor(){
        return "Xe máy " + super.getInfor();
    }
    @Override
    public void refuel(double liters) { this.fuelLevel += liters; }
}
class ElectricCar extends Vehicle implements battery {
    private int batteryPercent ;
    public ElectricCar(String plate , String brand , int batteryPercent ){
        super(plate,brand);
        this.batteryPercent = batteryPercent;
    }
    @Override
    public String getInfor(){
        return "Xe điện " + super.getInfor();
    }
    @Override
    public void charge(int percent){ this.batteryPercent += percent;}
}
class Car extends Vehicle implements fuel {
    private double fuelLevel ;
    public Car(String plate , String brand , double fuelLevel ){
        super(plate,brand);
        this.fuelLevel = fuelLevel;
    }
    @Override
    public String getInfor(){
        return "Ô tô  " + super.getInfor();
    }
    @Override
    public void refuel(double liters) { this.fuelLevel += liters; }
}

public class chap3 {
    public static void main(String[] args) {
        MotorBike bike = new MotorBike("29A1-12345", "Honda", 2.0);
        ElectricCar eCar = new ElectricCar("30F-56789", "VinFast", 40);
        Car car = new Car("30G-99999", "Toyota", 15.5);


        System.out.println(bike.getInfor());
        System.out.println(eCar.getInfor());
        System.out.println(car.getInfor());
    }
}
