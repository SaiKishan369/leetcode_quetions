class Solution {
    static final int MOD = 1_000_000_007;

    int[] sum, sumSq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new int[4 * n];
        sumSq = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];

            update(1, 0, n - 1, prev + 1, i, 1);

            ans = (ans + sumSq[1]) % MOD;
            last[x] = i;
        }

        return (int) ans;
    }

    void update(int node, int start, int end,
                int l, int r, int val) {
        if (l > end || r < start) {
            return;
        }

        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, l, r, val);
        update(node * 2 + 1, mid + 1, end, l, r, val);

        sum[node] = (int) (((long) sum[node * 2]
                + sum[node * 2 + 1]) % MOD);

        sumSq[node] = (int) (((long) sumSq[node * 2]
                + sumSq[node * 2 + 1]) % MOD);
    }

    void apply(int node, int start, int end, int val) {
        long len = end - start + 1L;
        long s = sum[node];
        long v = val;

        sumSq[node] = (int) (
            (sumSq[node] + 2L * v * s + v * v % MOD * len) % MOD
        );

        sum[node] = (int) ((s + v * len) % MOD);
        lazy[node] = (int) ((lazy[node] + v) % MOD);
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        int val = lazy[node];

        apply(node * 2, start, mid, val);
        apply(node * 2 + 1, mid + 1, end, val);

        lazy[node] = 0;
    }
}