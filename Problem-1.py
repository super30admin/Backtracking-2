'''
    Time Complexity: O(2^n)
    Space Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, pivot, subset):
        self.result.append(subset[:])
        # base case
        if pivot == len(nums):
            return

        # logic
        
        for i in range(pivot, len(nums)):
            subset.append(nums[i])
            self.helper(nums,i+1,subset)
            subset.pop()