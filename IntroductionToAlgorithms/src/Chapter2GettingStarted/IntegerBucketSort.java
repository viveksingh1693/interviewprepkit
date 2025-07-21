package Chapter2GettingStarted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerBucketSort {


    private static void insertionSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int j = i - 1;
            int key = bucket.get(i);
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 0) {
            return;
        }

        int maxValue = Arrays.stream(arr).max().getAsInt();
        int minValue = Arrays.stream(arr).min().getAsInt();

        int bucketCount = (int) Math.sqrt(arr.length);
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        // Initialize empty buckets
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets

        for (int num : arr) {
            int index = (int) (
                    (long) (num - minValue) * (bucketCount - 1) /
                            (maxValue - minValue + 1)
            );
            buckets.get(index).add(num);
        }

        // Sort individual buckets and concatenate
        int index = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {42, 32, 33, 52, 37, 47, 51};

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
