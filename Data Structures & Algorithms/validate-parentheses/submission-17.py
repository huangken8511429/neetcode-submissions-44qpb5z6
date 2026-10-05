class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        character = {')':'(', ']': '[', '}':'{'}

        for c in s:
            if c not in character:
                stack.append(c)
            else:
                if len(stack) == 0 or stack[-1] != character[c]:
                    return False
                else:
                    stack.pop()
        return len(stack) == 0                   

