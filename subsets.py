"""
Runtime Complexity: Exponential and it depends on the length of nums array. Because we exhaustively create the lists.
Space Complexity: we create a new list each time for the path and this can be reduced using backtrack solution
because we create the list only when the index is equal to length of nums.
Yes, the code worked on leetcode.
"""


# choose or not choose case solution without backtracking
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        self.result = []
        self.helper(nums,0,[])
        return self.result
    
    def helper(self,nums,index,path):
        if index == len(nums):
            self.result.append(path)
            return
        # 0 case or not choose case
        self.helper(nums,index+1,path.copy())
        # 1 case or choose case
        path.append(nums[index])
        self.helper(nums,index+1,path.copy())

# choose or not choose using backtracking
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        self.result = []
        self.helper(nums,0,[])
        return self.result
    
    def helper(self,nums,index,path):
        if index == len(nums):
            self.result.append(path.copy())
            return
        # 0 case or not choose case
        self.helper(nums,index+1,path)
        # 1 case or choose case
        path.append(nums[index])
        self.helper(nums,index+1,path)
        size = len(path)
        path.pop(size-1)
        
                