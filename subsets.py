"""
Time - O(2^n)
Space - O(n)
"""
from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtrack(start, path):

            res.append(path[:])
            for i in range(start, len(nums)):
                # Include nums[i]
                path.append(nums[i])
                # Recurse
                backtrack(i + 1, path)
                # Backtrack
                path.pop()

        backtrack(0, [])
        return res
