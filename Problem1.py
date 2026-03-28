#Subsets

# use recrussion to create the possible subsets, use tmp result and keep on building on that for every recrussion and once crossed pop it
# Time -> N2^N rrecrusion branching 2 options at step and then building the final result 
# Space -> ON the tmpResult and the stack space

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