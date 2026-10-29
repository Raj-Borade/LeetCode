class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] tin = new int[n], tout = new int[n], dep = new int[n];
        int[][] up = new int[17][n];
        int[] val = new int[n];
        int[] bit = new int[n + 2];
        int[] timer = {0};

        for (int i = 0; i < n; i++) val[i] = 1 << (s.charAt(i) - 'a');

        dfs(0, 0, g, tin, tout, dep, up, timer);

        for (int i = 0; i < n; i++) {
            add(bit, tin[i], val[i]);
            add(bit, tout[i] + 1, val[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                int x = 1 << (p[2].charAt(0) - 'a'), d = val[u] ^ x;
                add(bit, tin[u], d);
                add(bit, tout[u] + 1, d);
                val[u] = x;
            } else {
                int v = Integer.parseInt(p[2]), w = lca(u, v, dep, up);
                int m = sum(bit, tin[u]) ^ sum(bit, tin[v]) ^ val[w];
                ans.add((m & (m - 1)) == 0);
            }
        }
        return ans;
    }

    void dfs(int u, int p, List<Integer>[] g, int[] tin, int[] tout,
             int[] dep, int[][] up, int[] t) {
        tin[u] = ++t[0];
        up[0][u] = p;
        for (int k = 1; k < up.length; k++)
            up[k][u] = up[k - 1][up[k - 1][u]];
        for (int v : g[u]) if (v != p) {
            dep[v] = dep[u] + 1;
            dfs(v, u, g, tin, tout, dep, up, t);
        }
        tout[u] = t[0];
    }

    int lca(int u, int v, int[] d, int[][] up) {
        if (d[u] < d[v]) { int t = u; u = v; v = t; }
        for (int k = up.length - 1; k >= 0; k--)
            if (d[u] - (1 << k) >= d[v]) u = up[k][u];
        if (u == v) return u;
        for (int k = up.length - 1; k >= 0; k--)
            if (up[k][u] != up[k][v]) { u = up[k][u]; v = up[k][v]; }
        return up[0][u];
    }

    void add(int[] b, int i, int x) {
        for (; i < b.length; i += i & -i) b[i] ^= x;
    }

    int sum(int[] b, int i) {
        int x = 0;
        for (; i > 0; i -= i & -i) x ^= b[i];
        return x;
    }
}