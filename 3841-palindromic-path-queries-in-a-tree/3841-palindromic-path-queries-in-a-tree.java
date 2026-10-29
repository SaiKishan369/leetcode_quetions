
import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[n][LOG];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] mask = new int[n];
        char[] chars = s.toCharArray();

        int[] stack = new int[n];
        int[] parent = new int[n];
        int[] iter = new int[n];
        int top = 0, timer = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[top - 1];

            if (iter[u] == 0) {
                tin[u] = timer++;
                up[u][0] = parent[u];

                for (int j = 1; j < LOG; j++) {
                    up[u][j] = up[up[u][j - 1]][j - 1];
                }

                mask[u] = (u == 0 ? 0 : mask[parent[u]])
                        ^ (1 << (chars[u] - 'a'));
            }

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        Fenwick fw = new Fenwick(n);
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                        ^ (1 << (c - 'a'));

                if (delta != 0) {
                    fw.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int a = lca(u, v, depth, up, LOG);

                int mu = mask[u] ^ fw.pointQuery(tin[u]);
                int mv = mask[v] ^ fw.pointQuery(tin[v]);

                int pathMask = mu ^ mv ^ (1 << (chars[a] - 'a'));

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    private int lca(int u, int v, int[] depth, int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int i, int val) {
            for (; i <= n + 1; i += i & -i) {
                bit[i] ^= val;
            }
        }

        int query(int i) {
            int ans = 0;
            for (; i > 0; i -= i & -i) {
                ans ^= bit[i];
            }
            return ans;
        }

        void rangeXor(int l, int r, int val) {
            update(l + 1, val);
            update(r + 2, val);
        }

        int pointQuery(int i) {
            return query(i + 1);
        }
    }
}
