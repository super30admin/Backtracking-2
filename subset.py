# Time Complexity : O(N * 2^n) - 2^n is since we are taking 0 and 1 and O(N) because putting copy of each list inside the result
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Backtracking
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        if not nums or len(nums) == 0:
            return self.result
        
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, i , path):
        #Base case
        if i == len(nums):
            # Here I require new list since we are doing add and pop() at same path which result null 
            # can be avoided by creating a new path
            self.result.append(list(path)) #when we reach leaf then we are adding to result listd 
            return 
        
        # logic
        #don't choose
        self.helper(nums, i+1, path)
        #choose case
        #Action
        path.append(nums[i])
        
        # Recurse
        self.helper(nums, i+1, path)
        
        # backtrack
        path.pop()
        
        
# Recursion with same space and time complexity

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if not nums or len(nums) == 0:
            return self.result
        
        self.helper(nums, 0, list())
        return self.result
    
    def helper(self, nums, i , path):
        #Base case
        if i == len(nums):
            self.result.append(path) #when we reach leaf then we are adding to result listd 
            return 
        
        # logic
        #don't choose
        self.helper(nums, i+1, list(path))
        #choose
        path.append(nums[i])
        self.helper(nums, i+1, list(path))
