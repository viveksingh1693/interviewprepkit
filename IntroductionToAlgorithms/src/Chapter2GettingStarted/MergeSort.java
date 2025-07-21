package Chapter2GettingStarted;

import java.util.Arrays;

public class MergeSort {


    // Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //Sort left
            mergeSort(arr, left, mid);

            //Sort right
            mergeSort(arr, mid + 1, right);

            //merge sorted arrays
            merge(arr, left, mid, right);
        }
    }


    // Merge two sorted subarrays: arr[left..mid] and arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        //Copy Remaining left
        while (i < n1) {
            arr[k++] = L[i++];
        }

        //Copy remaining right
        while (j < n2) {
            arr[k++] = R[j++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        UtilMethods.printArray("Original: ", arr);
        mergeSort(arr, 0, arr.length - 1);
        UtilMethods.printArray("Sorted array: ", arr);
    }
}
