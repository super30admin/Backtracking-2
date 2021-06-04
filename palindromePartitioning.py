class Solution:
    def __init__(self):
        self.result = []
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if not nums:
            return None
        
        self.helper(nums, list(), 0)
        return self.result
    
    def helper(self, nums, path, index):
        #base
        self.result.append(path)
        for i in range(index, len(nums)):
            temp = list(path)
            temp.append(nums[i])
            self.helper(nums, temp, i+1)
               
        
        
        
