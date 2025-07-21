package array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Create buckets based on frequencies
        // Each bucket index represents frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }
        // Step 4: Collect top K frequent from end
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets[i].isEmpty()) {
                result.addAll(buckets[i]);
            }
        }

        // Convert to array
        return result.stream().limit(k).mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {

    }
}
