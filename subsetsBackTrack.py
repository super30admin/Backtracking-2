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
            self.result.append(list(path))
            return 
        #logic
        path.append(nums[i])
        self.helper(nums, path, i+1)
        path.pop(len(path)-1)
        self.helper(nums, path, i+1)
               
        
        
        
