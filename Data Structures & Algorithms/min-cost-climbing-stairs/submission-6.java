class Solution {
    public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int f0 = 0;
    int f1 = 0;

    // f[i]=min(f[i−1]+cost[i−1],f[i−2]+cost[i−2])
    for (int i = 1 ; i < n; i++) {
         int newF = Math.min(f0 + cost[i-1], f1 + cost[i]);
         f0 = f1;
         f1 = newF;
    }
    return f1;
 }
}
