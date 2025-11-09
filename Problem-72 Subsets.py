# 78. Subsets

# Time Complexity: O(2^n)
# Space Complexity: O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        if not nums:
            return result
        
        self.helper(nums, 0, [], result)
        return result
    
    def helper(self, nums, pivot, path, result):
        # Base
        if pivot == len(nums):
            return
        
        #
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path, result)
            result.append(list(path))
            path.pop()
        return
