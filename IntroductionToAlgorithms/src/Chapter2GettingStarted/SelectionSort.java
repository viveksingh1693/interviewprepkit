package Chapter2GettingStarted;

/**
 * Time Complexity O(n^2)
 * Space Complexity O(1)
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]){
                    minIdx= j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void selectionSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[maxIdx]){
                    maxIdx= j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        UtilMethods.printArray("Original: " , arr);
        selectionSort(arr);
        UtilMethods.printArray("Ascending: " , arr);
        selectionSortDesc(arr);
        UtilMethods.printArray("Descending: " , arr);
    }
}