"""
78. Subsets


Time = O(n*2^n) where n = number of elements in input array
space = O(n*2^n)
Successfully excecuted on leetcode

Approach:
1. DFS + recursion
2. At each step for given input array -> append the nums[i] and keep iterating till the last element
3. So recursion will have index, intermediate path and final result.
"""

class Solution:
    
    def subsets(self, nums):
        res = []
        self.dfs(nums, 0, [], res)
        return res
    
    def dfs(self, nums, index, path, res): 
        res.append(path)
        for i in range(index, len(nums)):
            self.dfs(nums, i+1, path+[nums[i]], res)
        
    