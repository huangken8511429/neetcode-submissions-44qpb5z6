class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = Counter()
        l, ans = 0, 0
        
        for r, x in enumerate(s):
            cnt[x] += 1
            while cnt[x] > 1:
                cnt[s[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)
        return ans        