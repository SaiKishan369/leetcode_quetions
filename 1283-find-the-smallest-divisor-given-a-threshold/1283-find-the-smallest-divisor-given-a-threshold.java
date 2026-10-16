class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // Find the maximum value in the array to set the upper bound of our search.
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // The search space for the divisor is from 1 to the maximum number in the array.
        int low = 1;         // The smallest possible divisor is 1.
        int high = maxVal;   // The largest necessary divisor is the max number itself.
        int ans = high;      // To store the best possible answer we've found so far.

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // A divisor of 0 is impossible, handle this edge case if mid can be 0.
            if (mid == 0) {
                low = 1;
                continue;
            }

            long sum = 0; // Use long for sum to prevent potential integer overflow.
            for (int num : nums) {
                // This is a correct and efficient way to calculate ceiling division.
                // (num + mid - 1) / mid is equivalent to Math.ceil((double) num / mid)
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                // If the sum is within the threshold, 'mid' is a potential answer.
                // We store it and try to find an even smaller divisor.
                ans = mid;
                high = mid - 1; 
            } else {
                // If the sum is too large, our divisor 'mid' is too small.
                // We need to look for a larger divisor.
                low = mid + 1;
            }
        }
        return ans;
    }
}