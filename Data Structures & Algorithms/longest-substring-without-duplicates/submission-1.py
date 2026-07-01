class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        charSet = set()
        ans = 0

        for c in list(s):
            while c in charSet:
                charSet.remove(s[left])
                left += 1
            charSet.add(c)
            ans = max(ans, len(charSet))

        return ans

        

        