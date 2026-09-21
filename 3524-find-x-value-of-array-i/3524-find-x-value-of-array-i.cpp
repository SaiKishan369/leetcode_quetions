class Solution {
public:
    vector<long long> resultArray(vector<int>& nums, int k) {
        vector<long long> result(k, 0);
        vector<long long> dp(k, 0);

        for (int num : nums) {
            vector<long long> newDp(k, 0);

            // Extend every previous subarray
            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) continue;

                int newRemainder = (r * (num % k)) % k;

                newDp[newRemainder] += dp[r];
            }

            // Start a new subarray with nums[i]
            newDp[num % k]++;

            // Add subarrays ending at this index
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
};