package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(nums[i])) {
                return new int[]{hm.get(nums[i]), i};
            } else {
                hm.put(diff, i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int[] ints = twoSum(nums, 9);
        for (Integer num: ints){
         System.out.print(num + " ");
        }
    }
}
