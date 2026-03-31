class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        
        // f[i+1][c] = Math.min(f[i][c] , f[i+1][c - nums[i]]+1)
        // f[c] = Math.min(f[c], f[c - nums[i]) + 1]);
        f[0] = 0;

        for (int coin : coins){
            for (int c = coin ; c <= amount; c++) {
                f[c] = Math.min(f[c], f[c - coin] + 1);
            }
        }
        int ans = f[amount];

        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
}
