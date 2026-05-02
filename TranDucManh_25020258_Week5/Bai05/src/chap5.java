package TranDucManh_25020258_Week5.Bai05.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

class Book{
    String id , title , author ;
    int year ;
    public Book(String id , String title , String author , int year ){
        this.id = id ;
        this.author = author ;
        this.title = title ;
        this.year = year ;
    }
    public String getId(){ return id ;}
    @Override
    public String toString(){
        return " ID " + id + "Author : " + author + "Title " + title ;
    }
}
class ArrayBook {
    ArrayList<Book> ar1 = new ArrayList<>();
    public void add(Book newB){
        for (Book a : ar1){
            if (a.getId().equals(newB.getId())){
                System.out.println("Cuon sach nay da ton tai ");
                return ;
            }
        }           
        ar1.add(newB);
        System.out.println("Tthm sachh thnah cong ");
 
    }
    public void FindBook(Book findB ){
        for ( Book a : ar1 ){
            if (a.getId().equals(findB.getId())){
                System.out.println("Sach nay ton tai voi id " + a.getId());
                return;
            }
        }
        System.out.println("Sach khong ton tai");
    }
    public void Remove(Book delB){
        ar1.removeIf(a -> a.getId().equals(delB.getId()));
    }
    public void display(){
        if (ar1.isEmpty()){
            System.out.println("THu vien trong ");
        }
        else {
            for ( Book  a : ar1 ){
                System.out.println(a);
            }
        }
    }
}


class MapBook{
    HashMap<String,Book> list = new HashMap<>();
    public void add(Book newB){
        if (!list.containsKey(newB.getId())){
            list.put(newB.getId() , newB);
            System.out.println("Them sach thanh cong  ");
        }
        else {
            System.out.println("Sach da ton tai");
        }
    }
    public void findB(String id ){
        Book b = list.get(id);
        if (b != null) System.out.println(b);
        else System.out.println("Khong tim thay");
    }
    public void remove(String id ){
        if (!list.containsKey(id)){
            System.out.println("Ban dang xoa sach khong ton tai");
        }
        else {
            list.remove(id);
            System.out.println("Xoa thanhcong ");
        }
    }

    
    public void display(){
        if (list.isEmpty()){
            System.out.println("Thu vien khong co sach ");
            return ;
        }
        for ( Book b : list.values()){
            System.out.println(b);
        }
    }
}


class TreeBook {
    TreeMap<String, Book> ds = new TreeMap<>();
    public void add(Book newB){
        if (!ds.containsKey(newB.getId())){
            ds.put(newB.getId() , newB);
            System.out.println("Them sach thanh cong  ");
        }
        else {
            System.out.println("Sach da ton tai");
        }
    }
    public void findB(Book findB){
        for ( Book b : ds.values()){
            if (b.getId().equals(findB.getId())){
               System.out.println(b);
                return ;
            }
        }
        System.out.println("Khong tim thay sach ");
    }
    public void remove(String id ){
        if (!ds.containsKey(id)){
            System.out.println("Ban dang xoa sach khong ton tai");
        }
        else {
            ds.remove(id);
            System.out.println("Xoa thanhcong ");
        }
    }


    public void display(){
        if (ds.isEmpty()){
            System.out.println("Thu vien khong co sach ");
            return ;
        }
        for ( Book b : ds.values()){
            System.out.println(b);
        }
    }


}





public class chap5 {
    public static void main(String[] args) {
Book b1 = new Book("01", "Conan", "OK", 1000);
    Book b2 = new Book("02", "DRB", "OK", 1000);
    Book b3 = new Book("03", "Doraemon", "OK", 1000);
    Book b4 = new Book("04", "Shin", "OK", 1000);
    Book b5 = new Book("05", "OnePiece", "OK", 1000);




    System.out.println("--- ARRAYLIST ---");
    ArrayBook ab = new ArrayBook();
    ab.add(b1); ab.add(b2); ab.add(b3); ab.add(b4); ab.add(b5);
    ab.FindBook(b2);
    ab.Remove(b1);
    ab.display();

    // --- 2. HASHMAP ---
    System.out.println("\n--- HASHMAP ---");
    MapBook mb = new MapBook();
    mb.add(b1); mb.add(b2); mb.add(b3); mb.add(b4); mb.add(b5);
    mb.findB("03");
    mb.remove("02");
    mb.display();

    // --- 3. TREEMAP ---
    System.out.println("\n--- TREEMAP ---");
    TreeBook tb = new TreeBook();
    tb.add(b5); tb.add(b1); tb.add(b4); tb.add(b2); tb.add(b3); // Thêm lộn xộn
    tb.findB(b4);
    tb.remove("05");
    tb.display();

    }
}
