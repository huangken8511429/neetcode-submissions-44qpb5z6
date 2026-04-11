class Solution {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  
             return 0;
       }
       Queue<String> queue = new ArrayDeque<>();
       queue.offer(beginWord);
       Map<String,Integer> wordToPath = new HashMap<>();
       wordToPath.put(beginWord, 1);
       
       while (!queue.isEmpty()) {
        String w = queue.poll();
        int path = wordToPath.get(w);
        
        for (int i = 0 ; i < w.length(); i++) {
            char[] words = w.toCharArray();
            for (char k = 'a'; k <= 'z'; k++) {
                words[i] = k;
                String newWord = new String(words);
                if (newWord.equals(endWord)) {
                    return path + 1;
                }
                if (wordSet.contains(newWord) && !wordToPath.containsKey(newWord)) {
                    wordToPath.put(newWord, path + 1);
                    queue.offer(newWord);
                }
            }
         }
       }
       return 0;
    }
}
