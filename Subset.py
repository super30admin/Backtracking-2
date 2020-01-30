#TC-O(N*2^N)
#SC-o(2^N)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        if((len(nums)==0) or (nums==None)):
            return self.res
        self.backtrack(nums,0,[])
        return self.res
    
    
    
    def backtrack(self,nums,index,temp):
        #base
        if(index>len(nums)):
            return
        
        
        #logic
        self.res.append(list(temp))
        for i in range(index,len(nums)):
            temp.append(nums[i])
            self.backtrack(nums,i+1,temp)
            temp.pop(-1)
