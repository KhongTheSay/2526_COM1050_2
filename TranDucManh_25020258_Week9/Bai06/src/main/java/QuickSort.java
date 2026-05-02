package main.java;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Chia mảng và lấy vị trí pivot
            int pivotIndex = partition(arr, low, high);

            // Sắp xếp nửa bên trái
            quickSort(arr, low, pivotIndex - 1);

            // Sắp xếp nửa bên phải
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Chọn phần tử cuối làm pivot
        int pivot = arr[high];

        // i là vị trí của phần tử nhỏ hơn pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Đưa pivot về đúng vị trí
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}