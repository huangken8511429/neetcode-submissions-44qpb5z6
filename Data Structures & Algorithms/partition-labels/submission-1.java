class Solution {
    // xyxxyzbzbbisl 
    // x : 3
    // y : 4
    // z : 7
    // b : 9
    // i : 10
    // s : 11
    // l : 12
    Map<Character, Integer> lastIndex = new HashMap<>();
    public List<Integer> partitionLabels(String s) {
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0 ; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
