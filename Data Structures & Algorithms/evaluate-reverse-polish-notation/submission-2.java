class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack();
        for (String token : tokens) {
           if ("+".equals(token)) {
            number.push(number.pop() + number.pop());
           } else if ("-".equals(token)) {
            int a = number.pop();
            int b = number.pop();
            number.push(b - a);
           } else if ("*".equals(token)) {
            number.push(number.pop() * number.pop());
           } else if ("/".equals(token)) {
             int a = number.pop();
             int b = number.pop();
             number.push(b / a);
           } else {
            number.push(Integer.parseInt(token));
           }
        }
        return number.pop();
    }
}
