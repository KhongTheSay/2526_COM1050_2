package TranDucManh_25020258_Week6.Bai04.src;
import java.util.Random;




interface Sorter {
    int [] sort ( int [] arr);
}


class LegacySorter {
    private Random random = new Random();

    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private void sort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            sort(nums, low, p);
            sort(nums, p + 1, high);
        }
    }
    private int partition(int[] nums, int low, int high) {
        int pIdx = low + random.nextInt(high - low + 1);
        int tempP = nums[low];
        nums[low] = nums[pIdx];
        nums[pIdx] = tempP;
        
        int pivot = nums[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do { i++; } while (nums[i] < pivot);
            do { j--; } while (nums[j] > pivot);
            if (i >= j) return j;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

class SortedAdapter implements Sorter {
    private LegacySorter s ;
    public SortedAdapter (LegacySorter s){
        this.s = s ;
    }
    @Override
    public int[] sort(int arr[]){
        return s.quickSort(arr);
    }
}

public class chap4 {
    public static void main(String[] args) {
        int [] list = {4,5,3,33,5,7,4,4,2,2,5,4,22,44,55,2345,42};
        LegacySorter sx = new LegacySorter();
        Sorter k = new SortedAdapter(sx);
        int [] ans = k.sort(list);
        for ( int i : ans){ System.out.print(i+" ");}

    }
}
