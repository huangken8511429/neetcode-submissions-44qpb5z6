class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        result, left = 0, 0
        cnt = Counter()
        for right, c in enumerate(s):
            cnt[c] += 1

            while right - left + 1 - max(cnt.values()) > k:
                cnt[s[left]] -= 1
                left += 1
            result = max(result, right - left + 1)
        return result