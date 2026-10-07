class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        // Only one element
        if (n == 1) {
            return nums[0];
        }

        // Single element is at the beginning
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Single element is at the end
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // mid itself is the single element
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1]) {

                return nums[mid];
            }

            if (mid % 2 == 0) {

                // odd-even pattern => we are on right side
                if (nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                }
                // even-odd pattern => we are on left side
                else {
                    low = mid + 1;
                }

            } else {

                // odd-even pattern => we are on left side
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                }
                // even-odd pattern => we are on right side
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}