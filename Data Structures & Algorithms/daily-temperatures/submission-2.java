class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //[1,4,1,2,1,0,0] 
        //[40,28]
        // 0, 0
        Stack<int[]> stack = new Stack<>(); // temperature, index
        int[] result = new int[temperatures.length];
        for (int index = 0; index < temperatures.length; index++) {
            int temperature = temperatures[index];
            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int[] pop = stack.pop();
                result[pop[1]] = index - pop[1];
            }
            stack.push(new int[]{temperature,index});
        }
        return result;
    }
}
