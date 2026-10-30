class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
 
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            long wt = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (wt != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return (int) wt;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];

                int nextCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                if (nextCount > k) {
                    continue;
                }

                long nextWt = wt + weight;

                if (nextWt < dist[v][nextCount]) {
                    dist[v][nextCount] = nextWt;
                    pq.offer(new long[]{nextWt, v, nextCount});
                }
            }
        }

        return -1;
    }
}
