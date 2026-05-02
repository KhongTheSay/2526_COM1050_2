package TranDucManh_25020258_Week6.Bai03.src;

interface Button {
    void render();
}
interface CheckBox {
    void render();
}

class WinButton implements Button {
    @Override
    public void render() {
        System.out.println("Button of Window ");
    }
}
class WinCheckBox implements CheckBox{
    @Override
    public void render(){
        System.out.println("Window checkbox");
    }
}
class MacButton implements Button {
    @Override
    public void render(){
        System.out.println("MAcOS checkbox ");
}
}
class MacCheckBox implements CheckBox {
    @Override
    public void render(){
        System.out.println("MAcOs CheckBox");
  }
}


interface UIfactory {
    Button  createButton();
    CheckBox  createCheckBox();
}


class CreateWin implements UIfactory {
    public Button createButton() {
        return new WinButton();
    }
    public CheckBox createCheckBox(){
        return new WinCheckBox ();
    }
}
class CreateMac implements UIfactory {
    public Button createButton(){
        return new MacButton();
    }
    public CheckBox createCheckBox (){
        return new MacCheckBox() ;
    }
}








public class chap3 {
    public static void main(String[] args) {
        UIfactory win ;
        UIfactory mac ;

        win = new CreateWin();
        Button winB = win.createButton();
        CheckBox winC = win.createCheckBox();
        winB.render();
        winC.render();

        mac = new CreateMac();
        Button macB = mac.createButton();
        CheckBox macC = mac.createCheckBox();
        macB.render();
        macC.render();
    }
}
