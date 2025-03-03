# Time Complexity : O(2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        
        def backtrack(k):
            if k == len(nums):
                res.append(subset[::])
                return
            
            backtrack(k+1)
            subset.append(nums[k])
            backtrack(k+1)
            subset.pop()
        
        backtrack(0)
        
        return res