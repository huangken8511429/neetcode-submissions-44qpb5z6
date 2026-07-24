from functools import cache


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        
        @cache
        def dfs(i):
            if i < 0:
                return True
            for j in range(i, -1, -1):
                if s[j:i+1] in wordSet:
                    if (dfs(j-1)):
                        return True
            return False

        return dfs(len(s) - 1)                


