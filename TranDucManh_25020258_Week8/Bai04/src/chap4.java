package TranDucManh_25020258_Week8.Bai04.src;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    static final int CAR = 0;
    static final int BIKE = 1;
    static final int TRUCK = 2;
    private final String plate;
    private final int type;
    public Vehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }
    public String getPlate() { return plate; }
    public int getType() { return type; }
    public abstract double calculateParkingFee(int hours);
    public int calculateBonusPoints(int hours) {
        int points = 1; 
        if (this.type == TRUCK && hours > 5) {
            points++;
        }
        return points;
    }
    
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() { return vehicle; }
    public int getHours() { return hours; }

    public double getFee() {
        return vehicle.calculateParkingFee(hours);
    }

    public int getBonus() {
        return vehicle.calculateBonusPoints(hours);
    }

    
}

class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        double totalFee = 0;
        int totalBonus = 0;
        StringBuilder result = new StringBuilder();

        result.append(getHeader());

        for (ParkingTicket t : tickets) {
            totalFee += t.getFee();
            totalBonus += t.getBonus();
            result.append(formatLine(t));
        }

        result.append(getFooter(totalFee, totalBonus));
        return result.toString();
    }
    private String getHeader() {
        return "Parking Receipt for " + name + "\n";
    }
    private String formatLine(ParkingTicket t) {
        return "\t" + t.getVehicle().getPlate() + "\t" + t.getFee() + "\n";
    }
    private String getFooter(double totalFee, int totalBonus) {
        return "Total fee is " + totalFee + "\n" +
               "You earned " + totalBonus + " bonus points";
    }
}

class Bike extends Vehicle {
    public Bike(String plate) { super(plate, Vehicle.BIKE); }

    @Override
    public double calculateParkingFee(int hours) {
        double fee = 5;
        if (hours > 3) fee += (hours - 3) * 2;
        return fee;
    }
}

class Car extends Vehicle {
    public Car(String plate) { super(plate, Vehicle.CAR); }

    @Override
    public double calculateParkingFee(int hours) {
        double fee = 10;
        if (hours > 2) fee += (hours - 2) * 3;
        return fee;
    }
}

class Truck extends Vehicle {
    public Truck(String plate) { super(plate, Vehicle.TRUCK); }

    @Override
    public double calculateParkingFee(int hours) {
        return 15 + hours * 4;
    }
}

public class chap4 {
    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("Trần Đức Mạnh");
        customer.addTicket(new ParkingTicket(new Car("29A-12345"), 3));
        customer.addTicket(new ParkingTicket(new Bike("29UET-001"), 4));
        customer.addTicket(new ParkingTicket(new Truck("29C-56789"), 6));
        
        System.out.println(customer.receipt());
    }
}