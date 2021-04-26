# Time Complexity: O(2^n) * O(n) for copying elements
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        if not nums:
            return self.res
        self.helper(nums, 0, [])
        return self.res
        
    def helper(self, nums, index, path):
        if index == len(nums):
            self.res.append(path.copy())
            return 
        
        self.helper(nums, index + 1, path)
        path.append(nums[index])
        self.helper(nums, index + 1, path)
        path.pop()
        