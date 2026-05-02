package TranDucManh_25020258_Week5.Bai02.src;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Customer {
    String name ;
    int id ;
    public Customer ( String name , int id ){
        this.name = name ;
        this.id = id ;
    }
}


class Message{
    String content ;
    int id ;
    public Message (int id , String content ){
        this.id = id ;
        this.content = content ;
    }
    @Override
    public String  toString(){
        return content ; 
    }
}


public class chap2 {
    public static void addM(Stack<Message> tinnhan, Message msg) {
        tinnhan.push(msg);
        System.out.println("Nhan vien :  " + msg);
    }
    public static void xuly(Queue<Customer> khach, Stack<Message> tinnhan){
        Customer kh = khach.poll();
        if (kh == null ){
            System.out.println("Hoan thanh cong viec   ");
            return ;
        }
        addM(tinnhan, new Message(01, "Hello  " + kh.name));
        addM(tinnhan, new Message(02, "Waiting nhé " + kh.name));
        addM(tinnhan, new Message(03, "Thanks " + kh.name));
        if (!tinnhan.isEmpty()){
            System.out.println("Cau vua go : "+tinnhan.peek());
        }
        if (!tinnhan.isEmpty()){
            Message del = tinnhan.pop();
            System.out.println("Deleted mesage  " + del);
        }
    }
    

    public static void main(String[] args) {
        Queue<Customer> khach = new LinkedList<>();
        Stack<Message> tinnhan = new Stack<>();

        Customer Manh = new Customer("Manh ", 01);
        Customer Lop = new Customer("Lop", 02);

        khach.add(Manh);
        khach.add(Lop);

        xuly(khach,tinnhan);
        xuly(khach,tinnhan);
        xuly(khach,tinnhan);
    }
}
