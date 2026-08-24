class Solution:
    def checkValidString(self, s: str) -> bool:
        lower = higher = 0
        for c in s:
            if c == '(':
                lower += 1
                higher += 1
            elif c == ')':
                lower -= 1
                higher -= 1
            elif c == '*':
                lower -= 1
                higher += 1
            if higher < 0:
                return False
            lower = max(0, lower)
        return lower == 0            
                        