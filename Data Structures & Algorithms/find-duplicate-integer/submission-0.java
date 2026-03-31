class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if (slow == fast) {
               break;
            }
        }

        int head = 0;
        while (true) {
            head = nums[head];
            slow = nums[slow];
            if (head == slow) {
                return slow;
            }
        }
    }
}
