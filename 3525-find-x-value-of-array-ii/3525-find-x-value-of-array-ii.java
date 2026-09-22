class Solution {

    static class Node {
        int product;
        int[] prefixCount;

        Node(int k) {
            prefixCount = new int[k];
        }
    }

    int n;
    int k;
    Node[] tree;
    int[] nums;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.nums = nums;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Point update
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Query range [start, n-1]
            Node queryNode = query(1, 0, n - 1, start, n - 1);

            result[q] = queryNode.prefixCount[x];
        }

        return result;
    }

    // --------------------------------------------------
    // Build
    // --------------------------------------------------

    void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].prefixCount[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // --------------------------------------------------
    // Merge
    // --------------------------------------------------

    Node merge(Node leftNode, Node rightNode) {

        Node result = new Node(k);

        // Product of the entire segment
        result.product =
                (leftNode.product * rightNode.product) % k;

        // Prefixes completely inside the left segment
        for (int r = 0; r < k; r++) {
            result.prefixCount[r] += leftNode.prefixCount[r];
        }

        // Prefixes that extend into the right segment
        for (int r = 0; r < k; r++) {

            int newRemainder =
                    (leftNode.product * r) % k;

            result.prefixCount[newRemainder] +=
                    rightNode.prefixCount[r];
        }

        return result;
    }

    // --------------------------------------------------
    // Update
    // --------------------------------------------------

    void update(int node, int left, int right,
                int index, int value) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].prefixCount[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] =
                merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // --------------------------------------------------
    // Query
    // --------------------------------------------------

    Node query(int node, int left, int right,
               int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftResult =
                query(node * 2, left, mid, ql, qr);

        Node rightResult =
                query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftResult, rightResult);
    }
}