
# Time Complexity : O(n^n)
# Space Complexity : O(n)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def subsets(self, nums):
       
        def backtrack(nums,res, curr, idx):
            res.append(list(curr))
            
            for i in range(idx, len(nums)):
                curr.append(nums[i])
                backtrack(nums, res, curr, i+1)
                curr.pop()
                
            
            
        res = []
        backtrack(nums,res, [], 0)
        return res