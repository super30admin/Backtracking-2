# APPROACH 1:  RECURSIVE
# Time Complexity : O(n * 2^n), n: len(nums)
# Space Complexity : O(n * 2^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. At each index, two options, maintain current path locally (each time pass a copy of the path)
# 2. If choose -> add path to the global var result, cant choose the same element again. If don't choose -> inc. index. Recursively call the function
# 3. return global var result.

class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if nums is None:
            return None
        
        self.helper(nums, 0, [])
        return self.result
    
    
    def helper(self, nums, index, curr_path):
        if index == len(nums):
            self.result.append(curr_path)
            return
        
        # logic
        # don't choose
        self.helper(nums, index + 1, copy.deepcopy(curr_path))
        
        # choose
        curr_path.append(nums[index])
        self.helper(nums, index + 1, copy.deepcopy(curr_path))
        
      
      
      
      
# APPROACH 2:  BACKTRACK
# Time Complexity : O(n * 2^n), n: len(nums)
# Space Complexity : O(n * 2^n), as we are creating a copy of the current path to add to result
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Explore all paths for each ind of candidates. At each node, append the current path to the result (not just on reaching the leaf node)
# 2. 1st action -> append current element to path, 2nd -> recurse on the next index (from which pivot again and explore all paths), 3rd -> backtrack (undo the action, remove 
#     the element from the list.
# 3. return the global var result.

class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if nums is None:
            return None
        
        self.helper(nums, 0, [])
        return self.result
    
    
    def helper(self, nums, index, curr_path):
        
        # logic
        self.result.append(copy.deepcopy(curr_path))
        for pos in range(index, len(nums)):
            # action
            curr_path.append(nums[pos])
            
            # recurse
            self.helper(nums, pos + 1, curr_path)
            
            # backtrack
            curr_path.pop()
