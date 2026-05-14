class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int minS = 0;
        int s = 0;
        for (int i = 0; i < gas.length; i++) {
            s += gas[i] - cost[i];
            if (s < minS) {
                minS = s;
                ans = i + 1;
            }
        }
        return s < 0 ? -1 : ans;
    }
}
