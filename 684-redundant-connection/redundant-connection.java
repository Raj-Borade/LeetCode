import java.util.*;

class Solution {
    class Pair {
        int vertex;
        int parent;

        Pair(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            boolean[] vis = new boolean[n + 1];

            if (bfs(u, v, vis, adj)) {
                return edges[i];
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }

    private boolean bfs(int src, int dest, boolean[] vis,
                        ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int vertex = q.remove();

            if (vertex == dest) {
                return true;
            }

            for (int ele : adj.get(vertex)) {
                if (!vis[ele]) {
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }

        return false;
    }
}