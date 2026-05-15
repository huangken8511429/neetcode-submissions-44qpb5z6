class MedianFinder {
    Queue<Integer> min;
    Queue<Integer> max;

    public MedianFinder() {
       min = new PriorityQueue<>((a, b) -> b - a);
       max = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        min.add(num);
        if (min.size() - max.size() > 1 || !max.isEmpty() && min.peek() > max.peek()) {
            max.add(min.poll());
        }
        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (max.peek() + min.peek()) / 2;
        } else if (min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) max.peek();
        }
        
    }
}
