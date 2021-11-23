# Leetcode 78 : subsets
# Time - Exponential
# Space - O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        result = []
        
        def helper(nums, index, path):
            
            result.append(path.copy())
            if index == len(nums):
                return
            # result.append(path.copy())
            for i in range(index, len(nums)):
                
                path.append(nums[i])
               
                helper(nums, i + 1, path)
                path.pop()
        
        helper(nums, 0, [])
        return result