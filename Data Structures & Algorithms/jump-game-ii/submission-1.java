class Solution {
    public int jump(int[] nums) {
       int currentEnd = 0;
       int jumps = 0;
       int farthest = 0;
       int goal = nums.length - 1;

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
