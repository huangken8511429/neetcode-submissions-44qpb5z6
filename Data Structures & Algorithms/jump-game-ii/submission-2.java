class Solution {
    public int jump(int[] nums) {
       int currentEnd = 0;
       int jumps = 0;
       int farthest = 0;
       int goal = nums.length - 1;

       // 每次取最大跳躍的值，當到達臨界值時，才算這次的JUMP，同時更新下一次最遠的距離
       // 這邊要小心跳到終點的時候不需要再跳了，所以是 < goal
       for (int i = 0; i < goal; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
             jumps++;
             currentEnd = farthest;
            }        
       }
       return jumps;      
    }
}
