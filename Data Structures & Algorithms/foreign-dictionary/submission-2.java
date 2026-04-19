class Solution {
   
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited;
     private List<Character> res;

    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0 ; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
             if (w1.length() > w2.length() && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                    return "";
                }
            for (int j = 0 ; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        res = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        
        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);
        for (char a : adj.get(c)) {
            if (dfs(a)) {
                return true;
            }
        }
        visited.put(c, false);
        res.add(c);
        return false;
    }


   
}