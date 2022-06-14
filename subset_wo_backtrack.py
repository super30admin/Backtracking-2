# Time Complexity : O(N * 2^N) where is N is number of elements
# Space Complexity : O(N*2) where N is number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.subsetFinder(nums, 0, [])
        
        return self.result
    
    def subsetFinder(self, nums, index, path):
        #base
        if index == len(nums):
            self.result.append(path)
            return
        #logic
        #not choose
        self.subsetFinder(nums, index + 1, path[:])
        
        #choose
        path.append(nums[index])
        self.subsetFinder(nums, index + 1, path[:])