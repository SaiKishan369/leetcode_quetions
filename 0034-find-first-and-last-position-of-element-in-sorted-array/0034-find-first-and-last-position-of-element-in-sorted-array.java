class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Find the first occurrence of the target
        int first = findFirstPosition(nums, target);

        // If the first occurrence is not found, the target doesn't exist in the array
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // Find the last occurrence of the target
        int last = findLastPosition(nums, target);

        return new int[]{first, last};
    }

    /**
     * Helper function to find the first (leftmost) occurrence of the target.
     */
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPosition = -1;

        while (left <= right) {
            // Standard way to calculate mid to prevent integer overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                // If mid element is the target, it might be the first one.
                // Store it and look for an earlier one in the left half.
                if (nums[mid] == target) {
                    firstPosition = mid;
                }
                // Continue searching in the left part
                right = mid - 1;
            } else { // nums[mid] < target
                // Target must be in the right half
                left = mid + 1;
            }
        }
        return firstPosition;
    }

    /**
     * Helper function to find the last (rightmost) occurrence of the target.
     */
    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                // If mid element is the target, it might be the last one.
                // Store it and look for a later one in the right half.
                if (nums[mid] == target) {
                    lastPosition = mid;
                }
                // Continue searching in the right part
                left = mid + 1;
            } else { // nums[mid] > target
                // Target must be in the left half
                right = mid - 1;
            }
        }
        return lastPosition;
    }
}