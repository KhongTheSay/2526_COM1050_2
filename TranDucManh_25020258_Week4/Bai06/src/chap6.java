package TranDucManh_25020258_Week4.Bai06.src;
class ArrayUtils {
    public static <T> void swap ( T[] array , int i , int j ){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp ; 
    }
    static <T extends Comparable<T>> void sort(T[] array){
        int n = array.length;
        for ( int i = 0 ; i < n-1 ; i++){
            for ( int j = 0 ; j < n - i - 1 ; j++){ 
                if (array[j].compareTo(array[j+1]) > 0 ){
                    swap(array , j+1 , j );

                }
            }
        }
    }
    static <T> void print(T[] array){
        for ( T n : array){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
class Student implements Comparable<Student> {
    String name ;
    double gpa ;
    public Student (String name , double gpa ){
        this.name = name ;
        this.gpa = gpa ;
    }
    @Override
    public int compareTo(Student other ){
        if (this.gpa < other.gpa) return -1;
        if (this.gpa > other.gpa ) return 1 ;
        return 0;
    }
    @Override
    public String toString(){
        return name + " - " + gpa ;
    }
}
public class chap6 {
    public static void main (String [] args ){
        Student a = new Student("Mạnh", 2.1);
        Student b = new Student("Hà",1.3);
        Student c = new Student("Lan",1.9);
        Integer [] list1  = {1,2,3,4,5,5};
        String [] list2 = {"dfghj","jtyui","tyuio"};
        Student [] list3 = {a,b,c};

        ArrayUtils.sort(list1);  // khi dùng 1 phương thức static từ hàm khác cần gh teenhafm đó + method 
        ArrayUtils.sort(list2);
        ArrayUtils.sort(list3);

        ArrayUtils.print(list1);
        ArrayUtils.print(list2);
        ArrayUtils.print(list3);
    }
}