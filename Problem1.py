# Time Complexity : O(2^n) where n is the number of elements in nums
# Space Complexity : O(n) where n is the depth of recursion
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Uses recursion to generate all subsets of an input list. 
# We either include or exclude each element, and record each unique subset at the end.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        
        res = []
        
        def helper(nums, i, path, res):
            if i >= len(nums):
                res.append(path[:])
                return
            helper(nums, i+1, path, res)
            path.append(nums[i])
            helper(nums, i+1, path, res)
            path.pop()
            
        helper(nums, 0, [], res)
        return res