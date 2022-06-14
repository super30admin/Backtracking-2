# Time Complexity : O(N * 2^N) where is N is number of elements
# Space Complexity : O(N) where N is number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def __init__(self):
        self.results = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0: return self.results
        self.subsetBuilder(nums, 0, [])
        
        return self.results
        
        
    def subsetBuilder(self, nums, index, currSet):
        #base
        if index == len(nums):
            self.results.append(currSet[:])
            return
        #logic
        #notChoose
        self.subsetBuilder(nums, index+1, currSet)
        #Choose
        #action
        currSet.append(nums[index])
        #recurse
        self.subsetBuilder(nums, index + 1, currSet)
        #backtrack
        currSet.pop()