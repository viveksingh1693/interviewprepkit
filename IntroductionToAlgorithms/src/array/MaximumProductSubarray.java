package array;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentMax = 1;
        int currentMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentMax = 1;
                currentMin = 1;
            }

            int temp = currentMax * nums[i];
            currentMax = Math.max(Math.max(temp, currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(temp, currentMin * nums[i]), nums[i]);
            result = Math.max(result,currentMax);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
