# Time Complexity o(2^n)
# Space Complexity o(n)


# Use backtracking everytime a decision in taken




class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        
        result = []
        path = []
        if nums == None and len(nums) == 0:
            return nums
        
        self.helper(nums, 0 , path ,result)
        
        return result
    
    def helper(self,nums, index , path ,result):
        
        
        if index == len(nums):
            
            result.append(path.copy())
            
            return
         
        
        s
        elf.helper(nums , index +1, path , result)
    
        
        path.append(nums[index])
        
        
        self.helper(nums , index +1, path , result)
        
        path.pop()