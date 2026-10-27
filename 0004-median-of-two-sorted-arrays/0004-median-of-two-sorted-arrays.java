class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array. This simplifies the binary search logic
        // by always performing the search on the array with fewer elements,
        // which helps in keeping 'j' (partition in nums2) non-negative.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Recursive call with swapped arrays
        }

        int m = nums1.length; // Length of the shorter array
        int n = nums2.length; // Length of the longer array

        // 'low' and 'high' define the binary search range for the partition point 'i' in nums1.
        // 'i' represents the number of elements taken from nums1 for the left half.
        // The range is [0, m], where 0 means no elements from nums1, and m means all elements from nums1.
        int low = 0;
        int high = m;

        // 'halfLen' is the target total number of elements in the left half of the merged array.
        // (m + n + 1) / 2 handles both odd and even total lengths correctly:
        // - If total length is odd (e.g., 5), halfLen = (5+1)/2 = 3. The median is the 3rd element.
        // - If total length is even (e.g., 4), halfLen = (4+1)/2 = 2. The median is the average of the 2nd and 3rd elements.
        int halfLen = (m + n + 1) / 2;

        // Perform binary search to find the optimal partition 'i' in nums1.
        while (low <= high) {
            // Calculate the partition point 'i' in nums1.
            // This is the standard way to find the middle index in binary search to prevent overflow.
            int i = low + (high - low) / 2;

            // Calculate the corresponding partition point 'j' in nums2.
            // The sum of elements in the left halves from both arrays must equal halfLen.
            int j = halfLen - i;

            // Define boundary values for the partitions.
            // L1: The last element of the left half from nums1.
            // R1: The first element of the right half from nums1.
            // L2: The last element of the left half from nums2.
            // R2: The first element of the right half from nums2.
            // Use Integer.MIN_VALUE and Integer.MAX_VALUE for edge cases where a partition is at
            // the beginning (i=0 or j=0) or end (i=m or j=n) of an array,
            // effectively treating non-existent elements as negative/positive infinity.
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if the current partition is valid:
            // This means all elements in the left halves (L1, L2) are less than or equal to
            // all elements in the right halves (R1, R2).
            // Specifically, L1 <= R2 and L2 <= R1 ensures the sorted property across the partition.
            if (L1 <= R2 && L2 <= R1) {
                // Correct partition found!
                // Now, calculate the median based on the total length (m + n).
                if ((m + n) % 2 == 1) { // Total length is odd
                    // The median is the largest element in the combined left half.
                    return Math.max(L1, L2);
                } else { // Total length is even
                    // The median is the average of the two middle elements.
                    // These are the largest element in the combined left half (max(L1, L2))
                    // and the smallest element in the combined right half (min(R1, R2)).
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {
                // L1 is too large, meaning our partition 'i' in nums1 is too far to the right.
                // We need to move 'i' to the left to find a smaller L1.
                high = i - 1;
            } else { // L2 > R1
                // R1 is too small, meaning our partition 'i' in nums1 is too far to the left.
                // We need to move 'i' to the right to find a larger R1.
                low = i + 1;
            }
        }

        // This line should theoretically not be reached if the input arrays are valid and sorted.
        // It's a fallback to satisfy the compiler and indicate an unexpected state.
        throw new IllegalArgumentException("Input arrays are not sorted or contain invalid data.");
    }

}