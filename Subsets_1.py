# Time Complexity : O(n × 2ⁿ) - 2ⁿ subsets × up-to-n cost to copy path into the result list
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using bactracking. 1. Action is appending nums[i] to path
# 2. Recurse calling helper function to get all the paths
# 3. Backtrack removing the elements from the path to get to the previous state to explore other combinations

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, idx, path):
        #base
        if len(nums) == idx:
            self.result.append(list(path))
            return
        #logic
        #no choose
        self.helper(nums, idx+1, path)
        #choose
        #action
        path.append(nums[idx])
        #recurse
        self.helper(nums, idx+1, path)
        #backtrack
        path.pop()
#Using 01 Recursion

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, pivot, path):
        self.result.append(list(path))
        #logic
        for i in range(pivot, len(nums)):
            #action
            path.append(nums[i])
            #recurse
            self.helper(nums, i+1, path)
            #backtrack
            path.pop()
#For loop recursion

