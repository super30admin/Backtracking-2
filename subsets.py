# Time Complexity : O(2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def backtrack(first=0, curr=[]):

            # if the current combination is same add it to the final output
            if len(curr) == k:
                results.append(curr[:])
                return

            # otherwise iterate through the entire length
            for i in range(first, n):

                # add nums[i] into the current combination
                curr.append(nums[i])

                # proceed to further integers
                backtrack(i + 1, curr)

                # backtrack by removing nums[i] from curr
                curr.pop()

        results = []

        n = len(nums)
        for k in range(n + 1):
            backtrack()
        return results
