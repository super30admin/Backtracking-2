# Time Complexity : O(2^n), where n is the length of nums (total number of subsets)
# Space Complexity : O(n), for the recursion stack depth during backtracking
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used backtracking to explore all possible combinations of the elements in nums.
# At each index, I decided whether to include the current number or not, and recursed accordingly.
# This way, I built all possible subsets without duplicates.

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(start, path):
            result.append(path[:])  # I added a copy of the current subset
            for i in range(start, len(nums)):
                path.append(nums[i])
                backtrack(i + 1, path)  # Move forward with the current number included
                path.pop()  # Backtrack to explore subsets without nums[i]

        backtrack(0, [])
        return result
