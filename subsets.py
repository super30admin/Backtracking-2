'''
TC: O(n*2^n)
SC: O(n)
'''
class Solution:
    def __init__(self):
        self.res = [[]]
    
    def helper(self, idx, nums, curr):
        if idx >= len(nums):
            return
        
        for i in range(idx, len(nums)): # O(n)
            curr.append(nums[i])
            self.res.append(curr[:])
            self.helper(i + 1, nums, curr)
            curr.pop()
        
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return self.res
        
        self.helper(0, nums, [])
        return self.res
        
        