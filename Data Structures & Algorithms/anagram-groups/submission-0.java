class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToGroup = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            keyToGroup.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(keyToGroup.values());
    }
}
