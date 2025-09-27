# Time Complexity : O(2^n)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The approach here to do a backtrack either using 01 approach(choose, not choose) or using the iterative for loop approach to
# get all the subsets.

class Solution:
    def subsets01Recursion(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(path, idx):
            if idx == len(nums):
                result.append(path.copy())
                return

            helper(path, idx + 1)
            path.append(nums[idx])
            helper(path, idx + 1)
            path.pop()

        helper([], 0)

        return result


class Solution:
    def subsetsIterativeRecursion(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(path, pivot):
            result.append(path.copy())
            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(path, i + 1)
                path.pop()

        helper([], 0)

        return result

