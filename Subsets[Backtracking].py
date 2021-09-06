"""
Time Complexity : O(N * 2^N) where N is no. of elements in an array
Space Complexity : O(N) where N is no. of elements in an array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if len(nums) == 0:
            return self.result
        self.backtrack(nums, 0, [])
        return self.result
    def backtrack(self, nums, index, path):
        # Base
        if index == len(nums):
            # Make a new list to add to the result
            self.result.append(list(path))
            return
        # Logic
        # Don't choose case
        self.backtrack(nums, index + 1, path)
        
        # Choose case
        # Action
        path.append(nums[index])
        # Recurse
        self.backtrack(nums, index + 1, path)
        # Backtrack
        path.remove(nums[index])
        
        
        