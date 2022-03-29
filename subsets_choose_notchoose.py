#time- 2^n, space-h
import copy
class Solution:
    def __init__(self):
        self.res=[]
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums,0,[])
        return self.res
    def helper(self,nums,index,path):
        #base
        if index==len(nums):
            if path not in self.res:
                self.res.append(copy.copy(path))
            return
        #logic
        #not choose
        self.helper(nums,index+1,path)   
        path.append(nums[index])
        
        #choose
        self.helper(nums,index+1,path)
        path.pop()
        
        
            
        
        