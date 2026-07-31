class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        result, left = 0, 0
        cs = Counter()
        for right, c in enumerate(s):
            tail = s[right]
            cs[c] += 1

            while right - left + 1 - max(cs.values()) > k:
                head = s[left]
                cs[head] -= 1
                left += 1
            result = max(result, right - left + 1)
        return result