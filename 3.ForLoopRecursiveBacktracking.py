# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this 
class Solution:
    result = list()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0,list())
        return self.result
    def helper(self,nums, index,path):
        
        # base
        if index == 0:
            self.result.append(path+list())
        if path != []:
            self.result.append(path+list())
        if index == len(nums):
            return 
        
        # logic
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()
            
        
       