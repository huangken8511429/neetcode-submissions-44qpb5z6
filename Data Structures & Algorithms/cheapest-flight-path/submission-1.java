class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 建圖：adj[u] = [{v, price}, ...]
        List<int[]>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int[] f : flights) {
            adj[f[0]].add(new int[]{f[1], f[2]});
        }

        // dist[i] = 目前從 src 到 i 的最便宜價格
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS：一層代表多走一條邊
        // state = {node, costSoFar}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});

        // 最多 k 個中轉 = 最多 k+1 條邊 = BFS 走 k+1 層
        int stops = 0;
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0], cost = cur[1];
                for (int[] next : adj[node]) {
                    int nextNode = next[0], price = next[1];
                    int newCost = cost + price;
                    // 只在能變便宜的時候才繼續擴展
                    if (newCost < dist[nextNode]) {
                        dist[nextNode] = newCost;
                        queue.offer(new int[]{nextNode, newCost});
                    }
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}