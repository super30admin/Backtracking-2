# // Time Complexity : O(n*2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def subsets(self, nums ):
        res = []
        subset = []
        def dfs(i):
            
            # base case
            if i >= len(nums):
                res.append(subset.copy())
                return 
            
            # decision to include nums[i]
            subset.append(nums[i])
            dfs(i+1)
            
            # decision not to include nums[i]
            subset.pop()
            dfs(i+1)
            
        dfs(0)
        return res