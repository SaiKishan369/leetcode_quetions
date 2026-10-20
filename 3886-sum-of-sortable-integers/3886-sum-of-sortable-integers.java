class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;
            int prevLast = -1;

            for (int start = 0; start < n && valid; start += k) {
                int descents = 0;
                int drop = -1;

                for (int j = 0; j < k; j++) {
                    int cur = nums[start + j];
                    int next = nums[start + (j + 1) % k];

                    if (cur > next) {
                        descents++;
                        drop = j;
                    }
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                int first, last;

                if (descents == 0) {
                    first = nums[start];
                    last = nums[start + k - 1];
                } else {
                    first = nums[start + (drop + 1) % k];
                    last = nums[start + drop];
                }

                if (start > 0 && prevLast > first) {
                    valid = false;
                    break;
                }

                prevLast = last;
            }

            if (valid) ans += k;
        }

        return ans;
    }
}