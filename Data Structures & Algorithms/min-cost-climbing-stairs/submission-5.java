class Solution {
    public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
     int[] f = new int[n + 1];
    // f[i]=min(f[i−1]+cost[i−1],f[i−2]+cost[i−2])
    for (int i = 2 ; i <= n; i++) {
         f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
    }
    return f[n];
 }
}
