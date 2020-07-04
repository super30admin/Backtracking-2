"""
// Time Complexity : o(2^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution:
    def helper(self, nums, path, idx):
        #base
        
        #logic:
        self.res.append(path.copy()) #add all the subsets to result
        for i in range(idx, len(nums)):
            path.append(nums[i]) #add the number encountered to the temp list, path
            
            self.helper(nums, path, i + 1)
            path.pop()#remove the last added number to path
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = [] #global
        self.helper(nums,[],0) #start from index 0
        return self.res