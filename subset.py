# Time Complexity : O(n*2^n) - n is the len(nums)
# Space Complexity : O(n*2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Recursion
"""

# 0-1 recursion solution
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        self.helper(nums, [], 0)
        return self.result

    def helper(self, nums, path, index):
        # base condition
        if index == len(nums):
            self.result.append(list(path))
            return

        # logic
        path.append(nums[index])

        # recurse (choose)
        self.helper(nums, path, index + 1)

        # backtrack
        path.pop()

        # recurse (do not choose)
        self.helper(nums, path, index + 1)

# two for loop based solution
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = [[]]
        for num in nums:
            for i in range(0, len(result)):
                newSubset = list(result[i])
                newSubset.append(num)
                result.append(newSubset)

        return result