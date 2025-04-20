# Time Complexity: O(2^n)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.helper(nums, 0, [], result)
        return result
    def helper(self, nums, pivot, path, result):
           
           result.append(path[:])
           for i in range(pivot, len(nums)):
               path.append(nums[i])
               self.helper(nums, i+1, path, result)
               path.pop()