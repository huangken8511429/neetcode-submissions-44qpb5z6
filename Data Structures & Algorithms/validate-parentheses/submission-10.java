class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> keyToValue = Map.of(']','[', '}', '{', ')', '(');
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (keyToValue.containsKey(ch) && !stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek.equals(keyToValue.get(ch))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
