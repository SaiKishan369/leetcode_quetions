class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search to find the boundary
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Calculate how many positive integers are missing up to arr[mid].
            // An ideal array would have arr[mid] = mid + 1.
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                // The k-th missing number is in the right part of the array.
                left = mid + 1;
            } else {
                // The k-th missing number is in the left part (or before arr[mid]).
                right = mid - 1;
            }
        }
        return left + k;
    }
}