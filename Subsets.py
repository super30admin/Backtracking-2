# Time Complexity : O(n × 2^n) - 2^n subsets × up-to-n cost to copy path into the result list
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We iterate from the current pivot and add each element one by one into the path.
# For every choice, we recurse forward and then backtrack to explore other paths.
# We save a copy of the current list at every level to record all subsets.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.path = []
        self.helper(nums, 0)
        return self.res

    def helper(self, nums, pivot):
        self.res.append(self.path[:])
        for i in range(pivot, len(nums)):
            self.path.append(nums[i])
            self.helper(nums, i+1)
            self.path.pop()
        