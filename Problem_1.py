# // Time Complexity : we are going over all of the htem so O(n * 2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Tried this on my own and understood a bit about the problem
# // Your code here along with comments explaining your approach
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        
        def dfs(i):
            if i>=len(nums):
                res.append(subset.copy())
                return
            #including
            subset.append(nums[i])
            dfs(i+1)
            #not including
            subset.pop()
            dfs(i+1)
        dfs(0)
        return res
            