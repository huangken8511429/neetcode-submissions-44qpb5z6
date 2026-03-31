class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> letterToCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterToCount.put(c, letterToCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> letterToCount2 = new HashMap<>();
         for (char c : t.toCharArray()) {
            letterToCount2.put(c, letterToCount2.getOrDefault(c, 0) + 1);
        }
        if (letterToCount.size() != letterToCount2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : letterToCount.entrySet()) {
            if (!entry.getValue().equals(letterToCount2.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}

