class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();
       for (String token : tokens) {
        if ("+".equals(token)) {
          stack.push(stack.pop() + stack.pop());
        } else if ("-".equals(token)) {
          Integer a = stack.pop();
          Integer b = stack.pop();
          stack.push(b - a);
        } else if ("*".equals(token)) {
          stack.push(stack.pop() * stack.pop());
        } else if ("/".equals(token)) {
          Integer a = stack.pop();
          Integer b = stack.pop();
          stack.push(b / a);
        } else {
          stack.push(Integer.parseInt(token));
        }
       }
       return stack.pop();
    }
}
