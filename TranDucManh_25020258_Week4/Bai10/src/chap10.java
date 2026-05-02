package TranDucManh_25020258_Week4.Bai10.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    String ma, ten;

    public MediaItem(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public abstract void infor();
}

class Book extends MediaItem {
    String tg;
    int trang;

    public Book(String ma, String ten, String tg, int trang) {
        super(ma, ten);
        this.tg = tg;
        this.trang = trang;
    }

    @Override
    public void infor() {
        System.out.println(ten + " - " + tg + " - " + trang);
    }
}

class DVD extends MediaItem {
    public String dd;
    public int tgian;

    public DVD(String ma, String ten, String dd, int tgian) {
        super(ma, ten);
        this.dd = dd;
        this.tgian = tgian;
    }

    @Override
    public void infor() {
        System.out.println(ten + " - " + dd + " - " + tgian);
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> ls = new ArrayList<>();

    public void add(T i) {
        ls.add(i);
    }

    public void del(int i) {
        if (i >= 0 && i < ls.size()) {
            ls.remove(i);
        }
    }

    public void show() {
        for (T x : ls) {
            x.infor();
        }
    }
}

public class chap10 {
    public static void main(String[] args) {
        LibrarySection<Book> secB = new LibrarySection<>();
        LibrarySection<DVD> secD = new LibrarySection<>();

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String loai = sc.next();
            if (loai.equals("B")) {
                String ma = sc.next();
                String ten = sc.next();
                String tg = sc.next();
                int trang = sc.nextInt();
                secB.add(new Book(ma, ten, tg, trang));
            } else if (loai.equals("D")) {
                String ma = sc.next();
                String ten = sc.next();
                String dd = sc.next();
                int tgian = sc.nextInt();
                secD.add(new DVD(ma, ten, dd, tgian));
            }
        }

        secB.show();
        secD.show();

        sc.close();
    }
}