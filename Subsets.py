import copy
class Solution:
    def __init__(self):
        self.result=[]
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if nums==None or len(nums)==0:
            return self.result
        self.helper(nums,[],0)
        return self.result
    def helper(self,nums,temp,i):
        if i==len(nums):
            self.result.append(temp)
            return 
        #choose
        self.helper(nums,temp+[nums[i]],i+1)
        #not choose
        self.helper(nums,temp,i+1)
        
        
 time complexity is O(2 raise to n)
 Space comlexity is O(n*(2 raise to n))
    ===========================================================================
    
import copy
class Solution:
    def __init__(self):
        self.result=[]
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if nums==None or len(nums)==0:
            return self.result
        self.helper(nums,[],0)
        return self.result
    def helper(self,nums,temp,i):
        if i==len(nums):
            self.result.append(temp)
            return 
        #choose
        self.helper(nums,temp+[nums[i]],i+1)
        #not choose
        self.helper(nums,temp,i+1)
time complexity is O(2 raise to n)
Space comlexity is O(n*(2 raise to n))
