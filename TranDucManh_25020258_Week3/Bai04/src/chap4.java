// package TranDucManh_25020258_Week3.Bai04.src;
package TranDucManh_25020258_Week3.Bai04.src;

class Animal {
    public void makesound(){
        System.out.println("Animal sound ");
    }

}
class Dog extends Animal {
    @Override
    public void makesound(){
        System.out.println("Woof Woof");
    }
}
class Cat extends Animal {
    @Override
    public void makesound(){
        System.out.println("Meows Meows");
    }
    public void xacnhan(){
        System.out.println("Day la meo meo");
    }
}
class Duck extends Animal {
}

public class chap4 {
    public static void main ( String [] args ){
        Animal a = new Dog ();  // java đến tham chiếu để xem xem a thực cchaats là gì còn javac thì chỉ kiểm tra xem a có phải là một đối tượng của lớp Animal hay không , nếu có thì sẽ cho phép biên dịch , còn java thì sẽ kiểm tra xem a thực chất là một đối tượng của lớp nào để gọi đến phương thức makesound() của lớp đó
        
        
        // Cat c = (Cat) a ;
        // c.makesound();

        if ( a instanceof Cat){
            Cat d = (Cat) a ;
            d.xacnhan();
        }
        else {
            System.out.println("Day khong phai meo ");
        }
        
    }
}


