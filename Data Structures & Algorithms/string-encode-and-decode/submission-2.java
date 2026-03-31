class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append('#').append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
      List<String> results = new ArrayList<>();
      int i = 0;
      while (i < str.length()) {
        int j = i;
        while (str.charAt(j) != '#') {
            j++; 
        }
        int length = Integer.parseInt(str.substring(i, j));
        i = j + 1;
        j = i + length;
        results.add(str.substring(i, j));
        i = j;
      }
      return results;
    }
}

