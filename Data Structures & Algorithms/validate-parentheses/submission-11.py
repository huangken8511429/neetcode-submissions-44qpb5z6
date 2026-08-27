class Solution:
    def isValid(self, s: str) -> bool:
        bracket = {')':'(', '}':'{', ']':'['}
        stack = []

        for c in s:
            if c in bracket:
                top = stack.pop() if stack else '#'
                if top != bracket[c]:
                    return False
            else:
                stack.append(c)

        return not stack              