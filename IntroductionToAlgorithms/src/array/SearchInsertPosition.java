package array;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
