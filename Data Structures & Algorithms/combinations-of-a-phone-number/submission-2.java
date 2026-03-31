class Solution {
    public static final String[] MAPPING= new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();
      List<String> ans = new ArrayList<>();
      char[] path = new char[digits.length()];
      dfs(ans, path, digits.toCharArray(), 0);
      return ans;
    }

    private void dfs(List<String> ans, char[] path, char[] digits, int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }

        String letter = MAPPING[digits[i] - '0'];

        for (Character c : letter.toCharArray()) {
            path[i] = c;
            dfs(ans, path, digits, i + 1);
        }
        
    }
}
