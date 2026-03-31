class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(ans, path, 0, s);
        return ans;
    }
    private void dfs(List<List<String>> ans, List<String> path, int i, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i ; j < s.length(); j++) {
            if (isPalid(s,i,j)) {
                path.add(s.substring(i, j + 1));
                dfs(ans, path, j + 1, s);
                path.removeLast();
            }
        }
    }
    private boolean isPalid(String s, int left, int right) {
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
 }

