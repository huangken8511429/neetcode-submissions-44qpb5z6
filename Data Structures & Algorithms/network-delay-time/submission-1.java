class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       List<int[]>[] adj = new ArrayList[n + 1];
       Arrays.setAll(adj, i -> new ArrayList<>());

       for (int[] time: times) {
         adj[time[0]].add(new int[]{time[1], time[2]});
       }
       int[] dist = new int[n + 1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[k] = 0;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
       // COST, NODE
       pq.offer(new int[]{0, k});

       while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int cost = cur[0], node = cur[1];

        if (cost > dist[node]) continue;

        for (int[] a : adj[node]) {
            int newNode = a[0], newCost = a[1];
            if (cost + newCost < dist[newNode]) {
                dist[newNode] = cost + newCost;
                pq.offer(new int[]{cost + newCost, newNode});
            }
        }
       }
       int ans = 0;
       for (int i = 1 ; i < n + 1; i++) {
        if (dist[i] == Integer.MAX_VALUE) return -1;
        ans = Math.max(ans, dist[i]);
       }
       return ans;
    }
}
