"""
Time Complexity : O(2^n)
Space Complexity : combinationSum() - O(n) - because of list temp
                                     [O(h) - stack space, where h is the maximum depth of recursion]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class Solution:
    def subsets(self, nums):
        res = []
        if not nums or len(nums) == 0:
            return res
        
        res = self.backtrack(nums, 0, [], res)
        return res
        
    def backtrack(self, nums, index, temp, res):
        # base case
        if index == len(nums):
            res.append(temp.copy())
            return res
        
        # recursive case
        for i in range(index, len(nums)):
            temp.append(nums[i])
            res = self.backtrack(nums, i+1, temp, res)
            temp.pop()
            
        res.append(temp.copy())
        return res
    
s = Solution()
print(s.subsets([1,2,3]))