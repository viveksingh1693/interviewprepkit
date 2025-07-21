package Chapter2GettingStarted;

import java.util.*;

public class FloatBucketSort {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        @SuppressWarnings("unchecked")
        //create an empty bucket
        List<Float>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Put array elements in different buckets
        for (float num : arr) {
            int bucketIdx = (int) num * n;
            buckets[bucketIdx].add(num);
        }

        // 3. Sort individual buckets using Collections.sort or insertion sort
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4. Concatenate all buckets into arr[]
        int idx = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[idx++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.123f, 0.665f, 0.343f};

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
