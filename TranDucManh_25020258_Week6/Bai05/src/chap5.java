package TranDucManh_25020258_Week6.Bai05.src;
class Logger {
    private static  Logger instance = null ; 
    private Logger(){}
    public static Logger getInstance (){{
        if ( instance == null ){
            instance = new Logger();
        }
        return instance ;
    }}
}


interface Export {
    void notifi(String msg );
}
class PdfExport implements Export {
    @Override
    public void notifi(String msg){
        System.out.println("PDF Notifyyy");
    }
}
class ExelExport implements Export {
    @Override
    public void notifi(String msg){
        System.out.println("Exexel Notify ");
    }
}
abstract class ExportPlay{
    public abstract Export ExportPlay1();
    public void tb(String msg){
        Export a = ExportPlay1();
        a.notifi(msg);
    }
}
class Exel extends ExportPlay{
    @Override
    public Export ExportPlay1(){
        return new ExelExport();
    }
}
class Pdf extends ExportPlay{
    @Override
    public Export ExportPlay1(){
        return new PdfExport();
    }
}




interface Player{
    void play (String name);
}

class OldPlayer{
    void playFile(String name ){
        System.out.println("OLD" + name );
    }
}

class AdapterOLD implements Player {
    OldPlayer a ;
    public AdapterOLD (OldPlayer a){
        this.a = a ;
    }
    @Override
    public void play(String name ){
        a.playFile(name);
    }
}






public class chap5 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Logger a = Logger.getInstance();
            System.out.println("HashCode: " + a.hashCode());
        });

        Thread t2 = new Thread(() -> {
            Logger b = Logger.getInstance();
            System.out.println("HashoCode2: "  + b.hashCode());
        });
        t1.start();
        t2.start();

        ExportPlay p = new Pdf();
        p.tb("Hello PDF");
        
        ExportPlay e = new Exel();
        e.tb("Hello Excel");


        Player player = new AdapterOLD(new OldPlayer());
        player.play("Song.mp3");
    }
}
