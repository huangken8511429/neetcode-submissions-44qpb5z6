class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> letterToCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterToCount.put(c, letterToCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            letterToCount.put(c, letterToCount.getOrDefault(c,0) - 1);
            if (letterToCount.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}

