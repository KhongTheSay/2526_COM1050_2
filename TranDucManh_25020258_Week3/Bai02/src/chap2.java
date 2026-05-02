package TranDucManh_25020258_Week3.Bai02.src;
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
}
class Duck extends Animal {
}

public class chap2 {
    public static void main ( String [] args ){
        Animal [] zoo = new Animal[4];

        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Duck();
        zoo[3] = new Dog();

       

        for ( int i = 0 ; i < zoo.length ; i++){
            zoo[i].makesound();
        }
    }
}


