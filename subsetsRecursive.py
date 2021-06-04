class Solution:
    def __init__(self):
        self.result = []
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if not nums:
            return None
        
        self.helper(nums, list(), 0)
        return self.result
    
    def helper(self, nums, path, i):
        #base
        if i==len(nums):
            self.result.append(path)
            return 
        #logic
        #dont choose
        self.helper(nums, path, i+1)
        #choose
        temp = list(path)
        temp.append(nums[i])
        self.helper(nums, temp, i+1)
               
        
        
        
