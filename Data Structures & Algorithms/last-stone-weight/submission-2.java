class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int second = maxHeap.poll();
            if (max > second) {
                maxHeap.offer(max - second);
            }
        }
        return maxHeap.peek() != null ? maxHeap.peek() : 0;    
    }
}
