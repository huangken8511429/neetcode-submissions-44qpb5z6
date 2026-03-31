class Solution {
    public List<String> generateParenthesis(int n) {
        char[] path = new char[2 * n];
        List<String> ans = new ArrayList<>();
        dfs(0, 0, path, n, ans);
        return ans;
    }

    private void dfs(int left, int right, char[] path, int n,List<String> ans) {
        if (right == n) {
            ans.add(new String(path));
            return;
        }

        if (left < n) {
            path[left + right] = '(';
            dfs(left+1, right, path, n, ans);
        }
        
        if (right < left) {
            path[left + right] = ')';
            dfs(left, right + 1, path, n, ans);
        }
    }
}
