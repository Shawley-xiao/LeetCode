class Solution:
    def removeDuplicates(self, nums):
        sameCount = 0
        preNum = None
        totalLength = len(nums)
        for num in nums:
            index =  nums.index(num)
            print(index)
            if totalLength - sameCount <= index:
                break

            if preNum == num:
                samCount += 1
                temp = nums[index]
                nums[index] = nums[totalLength-sameCount]
                nums[totalLength-sameCount] = temp
        
        print(nums)
                

test = Solution().removeDuplicates([1, 1, 2])