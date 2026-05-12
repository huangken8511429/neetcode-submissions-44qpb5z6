class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        int m = s.length();
        int n = p.length();
        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean match = i < s.length() && s.charAt(i) == p.charAt(j) || i < s.length() && p.charAt(j) == '.';
        if (j+1 < p.length() && p.charAt(j+1) == '*') {
           return memo[i][j] = dfs(i, j+2, s, p,m,n) || (match && dfs(i+1, j, s, p,m,n)) ;
        } else {
            return memo[i][j] = match && dfs(i+1, j+1, s, p,m,n);
        }
    }
}
