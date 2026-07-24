class KthLargest {
    private int size;
    PriorityQueue<Integer> deque = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
            this.size = k;
            for (int num : nums) {
                deque.offer(num);
                if (deque.size() > this.size) {
                    deque.poll();
                }
            }
    }
    
    public int add(int val) {
        deque.offer(val);
        if (deque.size() > this.size) {
            deque.poll();
        }
        return deque.peek();
    }
}
