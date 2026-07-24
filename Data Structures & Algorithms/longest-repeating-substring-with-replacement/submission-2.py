class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if s == "":
            return 0
        left = 0
        right = 0
        char_max = 0
        word_num = Counter()
        n = len(s)
        for right, x in enumerate(s):
            # word_num.setdefault(x, 0)
            word_num[x] += 1
            char_max = max(char_max, word_num[x])
            if right - left + 1 > char_max + k:
                word_num[s[left]] -= 1
                left += 1
        return len(s) - left