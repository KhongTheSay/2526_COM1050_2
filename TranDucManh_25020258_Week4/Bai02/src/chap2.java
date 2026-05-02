package TranDucManh_25020258_Week4.Bai02.src;
interface CanFly{
    void fly();
}
interface CanSwim {
    void Swim();
}
interface Fight {
    void fight();
}

class ActionCharacter implements Fight  {
    @Override
    public void fight(){
        System.out.println("Dam boc ");
    }
}

class Hero extends ActionCharacter implements CanFly , CanSwim {
    @Override
    public void Swim (){
        System.out.println("Hero is Swimming ");
    }
    @Override
    public void fly (){
        System.out.println("You can fly ");
    }
}

public class chap2 {
    public static void main (String [] args ){
        Hero a = new Hero();

        CanSwim c = (CanSwim) a ;
        c.Swim();

        Fight d = (Fight) a ;
        d.fight();
    }
}