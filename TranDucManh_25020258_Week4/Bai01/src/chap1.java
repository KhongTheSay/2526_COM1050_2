package TranDucManh_25020258_Week4.Bai01.src;
abstract class Shape {
    protected int x , y ;
    public Shape (int x , int y ){
        this.x = x ;
        this.y = y ;
    }
    public abstract void draw();
    public abstract void erase();
    public void moveTo(int newX , int newY){
        erase();
        x = newX ;
        y = newY ;
        draw();
    }
}

class Circle extends Shape{
    public Circle (int x , int y ){
        super(x,y);
    }
    @Override
    public void draw(){
        System.out.println("Vẽ hình tròn tại điểm có tọa độ "  + x + y);
    }
    @Override
    public void erase(){
        System.out.println("Xóa hình tròn tại điểm : " + x + y );
    }
}


public class chap1 {
    public static void main (String [] args ){
        Circle a = new Circle(10,10);
        a.moveTo(20, 20);
    }
}