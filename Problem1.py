# Problem 1 : Subsets
# Time Complexity : O(n* 2^n)
# Space Complexity : O(n* 2^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# 0/1 Recursion with backtracking
from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # result variable will store the list of list of subset
        result = []
        # currpath variable will store the current list of subset
        currpath = []

        # recursion function to generate the combination of subsets
        def helper(nums: List[int], idx: int, currpath: List[int], result: List[List[int]]) -> None:
            # base case when the index is out of bounds
            if (idx == len(nums)):
                # append the deep copy of currpath list of subset to result
                result.append(currpath.copy())
                return

            # logic
            # case where the element at idx position is not selected
            # calling the helper function with i+1 since element should not be repeated
            helper(nums, idx + 1, currpath, result)

            # case where the element at idx position is selected
            # append the element at idx position to currpath
            currpath.append(nums[idx])
            # calling the helper function with i+1 since element should not be repeated
            helper(nums, idx + 1, currpath, result)
            # for backtracking removing the last element ie element at idx position
            currpath.pop()

        helper(nums, 0, currpath, result)
        return result


# For recusion without backtracking

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # result variable will store the list of list of subset
        result = []
        # currpath variable will store the current list of subset
        currpath = []

        # recursion function to generate the combination of subsets
        def helper(nums: List[int], pivot: int, currpath: List[int], result: List[List[int]]) -> None:
            # appendinf the currpath ie list of subset to result
            result.append(currpath)
            # for loop recursion from pivot position to end of the nums
            for i in range(pivot, len(nums)):
                # create a deep copy of currpath
                currPathCopy = currpath.copy()
                # append the element at i position to deep copy of currpath
                currPathCopy.append(nums[i])
                # calling the helper function with i+1 since element should not be repeated
                helper(nums, i + 1, currPathCopy, result)

        helper(nums, 0, currpath, result)
        return result
