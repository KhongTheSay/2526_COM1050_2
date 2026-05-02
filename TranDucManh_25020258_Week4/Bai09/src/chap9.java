package TranDucManh_25020258_Week4.Bai09.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    String ma, name;

    public Product(String ma, String name) {
        this.ma = ma;
        this.name = name;
    }

    public abstract void infor();
}

class Food extends Product {
    String hsd;

    public Food(String ma, String name, String hsd) {
        super(ma, name);
        this.hsd = hsd;
    }

    @Override
    public void infor() {
        System.out.println(name + " Co han su dung la : " + hsd);
    }
}

class Elec extends Product {
    String baohanh;

    public Elec(String ma, String name, String baohanh) {
        super(ma, name);
        this.baohanh = baohanh;
    }

    @Override
    public void infor() {
        System.out.println(name + " Co thoi gian bao hanh den :" + baohanh);
    }
}

class Kho<T extends Product> {
    private List<T> dsach = new ArrayList<>();

    public void setItem(T item) {
        dsach.add(item);
    }
    public void xuatKho(int ind) {
        if (ind >= 0 && ind < dsach.size()) {
            T Item = dsach.remove(ind);
            System.out.println("Thanh cong san pham " + Item.name + " ra kho");
        } else {
            System.out.println("Vi tri khong hop le!");
        }
    }

    public void KiemKe() {
        for (T hang : dsach) {
            hang.infor();
        }
    }
}
public class chap9 {
    public static void main(String[] args) {
        Kho<Elec> khoDT = new Kho<>();
        Kho<Food> KhoTP = new Kho<>();

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String ma = sc.next();
            if (ma.equals("TP")) {
                String name = sc.next();
                String hsd = sc.next();
                Food sp = new Food(ma, name, hsd);
                KhoTP.setItem(sp);
            } else if (ma.equals("DT")) {
                String name = sc.next();
                String baohanh = sc.next();
                Elec sp = new Elec(ma, name, baohanh);
                khoDT.setItem(sp);
            }
        }
        sc.close();
        KhoTP.KiemKe();
        khoDT.KiemKe();
        KhoTP.xuatKho(9);
        KhoTP.xuatKho(1);
        KhoTP.KiemKe();
    }
}