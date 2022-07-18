#T(N)= O(N*2^N)
#S(N)= O(N)

class Solution:
    res=[]
    def helper(self,nums,path,ind):
        #Base
        if ind>=len(nums):
            return
        
        path.append(nums[ind])
        self.res.append(path[:])
        for i in range(ind+1,len(nums)):  
            self.helper(nums,path,i)
            path.pop(-1)
        
        
        #Logic
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[[]]
        for i in range(len(nums)):
            self.helper(nums,[],i)
        return self.res