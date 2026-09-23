class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        // Find total sum
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long target = totalSum - x;

        // If target < 0, even removing everything isn't enough
        if (target < 0) {
            return -1;
        }

        // target == 0 means remove the entire array
        if (target == 0) {
            return n;
        }

        int left = 0;
        int maxLength = -1;
        long windowSum = 0;

        for (int right = 0; right < n; right++) {

            windowSum += nums[right];

            // Shrink window if sum becomes too large
            while (left <= right && windowSum > target) {
                windowSum -= nums[left];
                left++;
            }

            // Found a valid subarray
            if (windowSum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        // No valid subarray
        if (maxLength == -1) {
            return -1;
        }

        // Elements outside the kept subarray are removed
        return n - maxLength;
    }
}