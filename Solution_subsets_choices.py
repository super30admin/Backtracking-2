"""
time complexity O(2^N)
space complexity O(2^N)

recursive solution choose and dont choose
"""


class Solution_subsets_choices:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        if nums is None or len(nums)==0:
            return self.res
        temp=[]
        self.helper(nums,temp,0)
        return self.res
    
    def helper(self,nums,temp,i):
        #base 
        if(i==len(nums)):
            self.res.append(temp)
            return
        
        #logic
        #dont choose 
        self.helper(nums,temp,i+1)
    
        #choose
        temp1=copy.deepcopy(temp)
        temp1.append(nums[i])
        
        self.helper(nums,temp1,i+1)
    
            
        
        