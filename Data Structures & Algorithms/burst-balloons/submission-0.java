class Solution {
    int[][] cache;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i = 0 ; i < n; i++) {
            arr[i+1] = nums[i];
        }

        cache = new int[n+2][n+2];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return dfs(0, n+1, arr);
    }

    private int dfs(int i, int j, int[] arr) {
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return arr[i] * arr[i+1] * arr[j];
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int k = i + 1;
        int maxRes = 0;
        while (k < j) {
            int left = dfs(i, k, arr);
            int right = dfs(k, j, arr);
            int res = left + right + arr[i] * arr[k] * arr[j];
            maxRes = Math.max(maxRes, res);
            k++;
        }
        return cache[i][j] = maxRes;
    }
}
