
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;

        long[] diff = new long[n];
        long max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        long low = 0, high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long level = low;
        long used = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                used += diff[i] - level;
                diff[i] = level;
            }
            answer += diff[i] * diff[i];
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level && level > 0) {
                answer -= level * level;
                answer += (level - 1) * (level - 1);
                remaining--;
            }
        }

        return answer;
    }
}
