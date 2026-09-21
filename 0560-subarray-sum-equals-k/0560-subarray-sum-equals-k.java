import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        // A hash map to store the frequency of prefix sums.
        // Key: prefix sum, Value: frequency of that prefix sum.
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Initialize the map with a prefix sum of 0, which occurs once (before the array starts).
        prefixSumMap.put(0, 1);
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in the map.
            // If it does, it means there's a subarray ending at the current position
            // with a sum equal to k. The number of such subarrays is the frequency
            // of the prefix sum (currentSum - k).
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Update the map with the current prefix sum.
            // We use getOrDefault to handle cases where the current sum is seen for the first time.
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}