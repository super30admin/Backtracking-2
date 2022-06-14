# Time Complexity : O(N * 2^N) where is N is number of elements
# Space Complexity : O(N) where N is number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.subsetFinder(nums, [], 0)
        
        return self.result
    
    def subsetFinder(self, nums, subset, index):
        #base
        self.result.append(subset[:])
        
        #logic
        for i in range(index, len(nums)):
            subset.append(nums[i])
            self.subsetFinder(nums, subset, i+1)
            subset.pop()