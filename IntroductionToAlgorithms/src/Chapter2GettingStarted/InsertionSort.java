package Chapter2GettingStarted;

/**
 * Worst Case O(n^2)
 * Space complexity O(1)
 */
public class InsertionSort {

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void insertionSortDesc(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j]<key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        UtilMethods.printArray("Original: " , arr);
        insertionSort(arr);
        UtilMethods.printArray("Ascending: " , arr);
        insertionSortDesc(arr);
        UtilMethods.printArray("Descending: " , arr);
    }
}
