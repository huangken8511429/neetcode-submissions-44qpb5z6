class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> keyToGroups = new HashMap<>();
      for (String str : strs) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {   
           count[c - 'a']++;
        }
        String key = Arrays.toString(count);
        keyToGroups.computeIfAbsent(key, g -> new ArrayList<>()).add(str);
      }
      return new ArrayList<>(keyToGroups.values());      
    }
}
