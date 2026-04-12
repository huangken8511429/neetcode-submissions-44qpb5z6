class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. 建鄰接表：存 {鄰居, 權重}
        List<int[]>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, i -> new ArrayList<>());

        for (int[] t : times) {
            adj[t[0]].add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k}); // {cost, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];

            if (cost > dist[node]) continue; // 過時的舊路徑，跳過

            for (int[] next : adj[node]) {
                int neighbor = next[0], weight = next[1];
                int newCost = dist[node] + weight;

                if (newCost < dist[neighbor]) {
                    dist[neighbor] = newCost;
                    pq.offer(new int[]{newCost, neighbor});
                }
            }
        }

        // 3. 取最大延遲
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // 有節點到不了
            ans = Math.max(ans, dist[i]);
        }

        return ans;

    }
}
