class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0])); // 根據每個pair的區域做降序排序。
        Stack<Double> stack = new Stack<>();
        for (int[] pair : pairs) {
            double t = ((double) (target - pair[0]) / pair[1]);
            if (!stack.isEmpty() && t > stack.peek()) {
                stack.push(t);
            } else if (stack.isEmpty()) {
                stack.push(t);
            }
        }
        return stack.size();
    }
}
