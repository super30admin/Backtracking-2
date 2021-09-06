"""
Time Complexity : O(N * 2^N) where N is no. of elements in an array
Space Complexity : O(N * 2^N) where N is no. of elements in an array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if len(nums) == 0:
            return self.result
        self.recurse(nums, 0, [])
        return self.result
    def recurse(self, nums, index, path):
        # Base
        if index == len(nums):
            self.result.append(path)
            return
        # Logic
        # Choose case
        newList = path + [nums[index]]
        self.recurse(nums, index + 1, newList)
        # Don't choose case
        self.recurse(nums, index + 1, list(path))
        
        