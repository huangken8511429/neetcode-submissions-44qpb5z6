class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        ans_left = ans_right = 0

        for i in range(n):
            l = r = i
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l - 1 > ans_right - ans_left:
                ans_right = r
                ans_left = l + 1

        for i in range(n - 1):
            l , r = i, i+1
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l - 1 > ans_right - ans_left:
                ans_right = r 
                ans_left = l + 1

        return s[ans_left:ans_right]                       
