package TranDucManh_25020258_Week4.Bai05.src;
class Pair <K , V >{
    private K key ;
    private V value;
    public Pair (K key , V value ){
        this.key = key ;
        this.value = value ;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value ;
    }
    public void setKey(K key){
        this.key = key ;
    }
    public void setValue(V value ){
        this.value = value ;
    }
    @Override
    public String toString(){
        return key + " - " + value ;
    }
}

public class chap5 {
    public static void main (String [] args ){
        Pair <String,Integer> infor =  new Pair<>("Tuổi", 20);
        Pair <String,String> infor2 = new Pair<>("MA Sv " , " SV001");
        Pair <Integer,Double> infor3 = new Pair<>(105,21.3); // cannnot infer type argument for Pair

        System.out.println(infor);
        System.out.println(infor2);
        System.out.println(infor3);
    }
}