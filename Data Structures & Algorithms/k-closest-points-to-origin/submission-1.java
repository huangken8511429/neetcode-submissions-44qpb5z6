class Solution {
    PriorityQueue<int[]> minPoint = new PriorityQueue<>(
            (a, b)  -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
    );

    public int[][] kClosest(int[][] points, int k) {
        for (int [] point : points) {
            minPoint.offer(point);
            if (minPoint.size() > k) {
                minPoint.poll();
            }
        }
        int[][] result = new int[minPoint.size()][];
        int index = 0;
        while (!minPoint.isEmpty()) {
            result[index] = minPoint.poll();
            index++;
        }

        return result;
    }
}
