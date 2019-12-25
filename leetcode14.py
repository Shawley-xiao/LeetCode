class Solution:
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ""

        return self.checkCommonPrefix(strs[0], strs[1:])
    
    def checkCommonPrefix(self, check, strs):
        for strInList in strs:
            if not strInList.startswith(check):
                return self.checkCommonPrefix(check[0:-1], strs)
        
        return check

list1 = ["flower","flow","flight"]
result = Solution().longestCommonPrefix(list1)
print("result ==> "+ result)