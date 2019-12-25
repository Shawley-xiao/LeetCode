
class Solution:
    def isValid(self, s):
        list = []
        for char in s:
            if char == '(' or char == '{' or char == '[':
                list.append(char)
            elif char == ')' and len(list) > 0 and list[-1] == '(':
                list.pop()
            elif char == '}' and len(list) > 0 and list[-1] == '{':
                list.pop()
            elif char == ']'and len(list) > 0 and list[-1] == '[' :
                list.pop()
            else:
                return Fla
        return len(list) == 0


print(Solution().isValid("()"))
    