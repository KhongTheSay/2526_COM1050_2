package TranDucManh_25020258_Week8.Bai05.src;

abstract class Order {
    protected String type;
    protected double weight;
    protected double distance;

    public Order(String type, double weight, double distance) {
        this.type = type; this.weight = weight; this.distance = distance;
    }
    abstract public double getDeliveryFee();
    public String getLabel(){
        return "[Không xác định]";
    }
}
class Standard extends Order {
    public Standard (String type, double weight, double distance){
        super(type , weight , distance );
    }
    @Override
    public double getDeliveryFee(){
        return weight *3000 + distance *500;
    }
    @Override
    public String getLabel(){
        return "[THƯỜNG]";
    }
}
class Express extends Order {
    public Express (String type, double weight, double distance){
        super(type , weight , distance );
    }
    @Override
    public double getDeliveryFee(){
        return (weight * 3000 + distance * 500) * 1.5;
    } 
    @Override
    public String getLabel(){
        return "[HỎA TỐC]";
    }
}
class Fragile extends Order {
        public Fragile (String type, double weight, double distance){
        super(type , weight , distance );
    }
    @Override
    public double getDeliveryFee(){
        return weight * 5000 + distance * 700 + 20000;
    } 
    @Override
    public String getLabel(){
        return "[HÀNG DỄ VỠ]";
    }
}

class Bulky extends Order {
        public Bulky (String type, double weight, double distance){
        super(type , weight , distance );
    }
    @Override
    public double getDeliveryFee(){
        return weight * 4000 + distance * 600 + 50000;
    } 
    @Override
    public String getLabel(){
        return "[HÀNG CỒNG KỀNH]";
    }
}



public class chap5 {
    public static void main(String[] args) {
        Order o1 = new Standard("Sách", 2.5, 10);
        Order o2 = new Express("Điện thoại", 1.2, 5);
        Order o3 = new Fragile("Ly thủy tinh", 3, 8);
        Order o4 = new Bulky("Tủ lạnh", 20, 15);

        Order[] orders = {o1, o2, o3, o4};
        for (Order o : orders) {
            System.out.println("Loại: " + o.getLabel());
            System.out.println("Phí vận chuyển: " + o.getDeliveryFee());
            System.out.println("");
        }

}
}