# 78. Subsets
# https://leetcode.com/problems/subsets/

# Time Complexiety: O(n*(2^n))
# Space Complexiety: O(n)

class Solution:
    def __init__(self):
        self.result = list()
        
    def _helper(self, nums, idx, path):
        self.result.append(path.copy())
        # Base
        if idx == len(nums):    
            return
        
        for i in range(idx, len(nums)):
            # Action
            path.append(nums[i])
            
            # Recursion
            self._helper(nums, i+1, path)
            
            # Backtrack
            path.pop()
        
    
    def subsets(self, nums):
        self._helper(nums, 0, [])
        return self.result
