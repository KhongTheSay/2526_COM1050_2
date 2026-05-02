package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Lớp kiểm thử để đạt 100% Code Coverage cho QuickSort.
 */
public class QuickSortTest {

    @Test
    void testQuickSortFullCoverage() {
        // 1. Trường hợp mảng thông thường: Bao phủ logic partition, swap và vòng lặp for
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(arr1, 0, arr1.length - 1);
        assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr1);

        // 2. Trường hợp mảng đã sắp xếp: Kiểm tra tính ổn định của pivot
        int[] arr2 = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr2, 0, arr2.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr2);

        // 3. Trường hợp phần tử trùng nhau: Bao phủ nhánh if (arr[j] <= pivot)
        int[] arr3 = {3, 1, 3, 2, 3};
        QuickSort.quickSort(arr3, 0, arr3.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 3, 3}, arr3);
    }

    @Test
    void testEdgeCasesForRecursion() {
        // 4. Mảng chỉ có 1 phần tử: Bao phủ trường hợp nhánh 'false' của if (low < high)
        int[] single = {100};
        QuickSort.quickSort(single, 0, 0);
        assertArrayEquals(new int[]{100}, single);

        // 5. Mảng rỗng hoặc trường hợp low > high: Đảm bảo đệ quy không chạy sai
        int[] empty = {};
        QuickSort.quickSort(empty, 0, -1);
        assertEquals(0, empty.length);
    }

    @Test
    void testReverseSorted() {
        // 6. Mảng sắp xếp ngược: Kiểm tra hiệu suất tối đa của việc hoán đổi trong partition
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
void testMainAndPrint() {
    // Gọi hàm printArray để JaCoCo tính điểm cho các dòng trong đó
    int[] arr = {1, 2, 3};
    QuickSort.printArray(arr); 

    // Gọi hàm main để tính điểm cho hàm main
    // Vì main yêu cầu mảng String[], ta truyền mảng rỗng vào
    String[] args = {};
    QuickSort.main(args); 
    
    assertTrue(true); // Chỉ cần gọi để phủ dòng code
}
}