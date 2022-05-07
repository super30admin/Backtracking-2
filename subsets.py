# Leetcode 78 Subsets https://leetcode.com/problems/subsets/

# Empty subset is a valid subset

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        subset = []
        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy)
                return 

            # decision to include nums[i]
            subset.append(nums[i])
            dfs(i+1)

            #decision not to include nums[i]
            subset.pop() # empty subset will be passed to dfs
            dfs(i+1)

        dfs(0)
        return res