package dynamicprogramming;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public int[] maxSubArrayIndices(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        int tmpStart = 0;
        for (int i = 1; i < nums.length; i++) {

            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
                tmpStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                currentSum = maxSum;
                start = tmpStart;
                end = i;
            }

        }

        return new int[]{start, end};
    }


    public static void main(String[] args) {

    }
}

