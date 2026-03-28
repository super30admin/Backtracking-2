#Subsets

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        
        self.tmpResult = []

        self.helper(0, nums)
        return self.result

    def helper(self,index, nums):

        if index == len(nums):
            self.result.append(self.tmpResult[:])
            return
        #no choose 
        self.helper(index+1, nums)

        #choose
        self.tmpResult.append(nums[index])
        self.helper(index+1, nums)
        self.tmpResult.pop()
        
sol = Solution()
print(sol.subsets([1,2,3]))