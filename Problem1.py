# Time Complexity : O(2^number of nodes)
# Space Complexity :O(length of list * (2^number of nodes))
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def subsets(self, nums):
        res = []
        sorted(nums)
        def backtracking(path, index):
            res.append(path)
            for i in range(index, len(nums)):
                backtracking(path+[nums[i]],i+1)
        backtracking([], 0)
        return res
# For this sum, I am taking the sorted list and res for final answer.Then I am backtracking with a method for each subset: