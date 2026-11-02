class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Recursive call with swapped arrays
        }
        
        int m = nums1.length; // Length of the shorter array
        int n = nums2.length; // Length of the longer array

        int low = 0;
        int high = m;

        int halfLen = (m + n + 1) / 2;

        while (low <= high) {
            int i = low + (high - low) / 2;

            int j = halfLen - i;

            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (L1 <= R2 && L2 <= R1) {
                if ((m + n) % 2 == 1) { // Total length is odd
                    return Math.max(L1, L2);
                } else { // Total length is even
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {
                high = i - 1;
            } else { // L2 > R1
                low = i + 1;
            }
        }

        return -1;
    }

}