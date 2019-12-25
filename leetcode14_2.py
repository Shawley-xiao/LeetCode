class Solution:
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ""

        return self.checkCommonPrefix(1, strs)
    
    def checkCommonPrefix(self, offset, strs):
        check = strs[0][:offset]
        if len(check) == offset-1:
            return check

        for strInList in strs:
            if not strInList.startswith(check):
                return check[:-1]
        
        return self.checkCommonPrefix(offset+1, strs)

list1 = ["flower","flow","flight"]
result = Solution().longestCommonPrefix(list1)
print("result ==> "+ result)