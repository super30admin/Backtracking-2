"""
time complexity O(2^N)
space complexity O(2^N)

recursive solution
"""


class Solution_subsets_R:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        if nums is None or len(nums)==0:
            return self.res
        templist=[]
        self.helper(nums,templist,0)
        return self.res
    
    def helper(self,nums,temp1,pivot):
        #base 
        
        self.res.append(temp1)
        
        #logic
        for i in range(pivot,len(nums)):
            temp2=copy.deepcopy(temp1)
            temp2.append(nums[i])  #action
            self.helper(nums,temp2,i+1) #recurse
            
            
        