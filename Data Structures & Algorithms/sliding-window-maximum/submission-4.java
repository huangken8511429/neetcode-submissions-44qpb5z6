class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        if (nums.length < k) {
            return new int[0];
        }
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        int[] result = new int[nums.length - k + 1];
        int current = -10001;
        
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            q.addLast(right);

            if (left > q.getFirst()) {
                q.removeFirst();
            }

            if ((right - left + 1) >= k) {
                result[left] = nums[q.getFirst()];
                left++;
            }
        }
        return result;
    }
}
