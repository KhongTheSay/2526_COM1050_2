package TranDucManh_25020258_Week4.Bai04.src;
interface IData {
    public abstract void show();
}
class DataManager implements IData {
    @Override
    public void show (){
        System.out.println("Show Data ");
    }
}

public class chap4 {
    public static void main (String [] args ){
        DataManager a = new DataManager();
        a.show();
    }
}



// ddeer đảm bảo tính đa hình khoogn ị phá vỡ 
// Việc không cho thu hẹp phạm vi truy cập giúp đảm bảo nguyên lý Liskov Substitution Principle
//  — tức là object lớp con có thể thay thế object lớp cha mà không làm thay đổi tính đúng đắn của chương trình.