# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :
class Solution:
    result = list()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0,list())
        return self.result
    def helper(self,nums, index,path):
        
        # base
        if index == len(nums):
            self.result.append(path+list())
            return 
        
        # logic
        # not choose
        self.helper(nums, index+1, path)
        
        # choose
        path.append(nums[index])
        self.helper(nums, index+1, path)
        
        # backtrack
        path.pop()
        