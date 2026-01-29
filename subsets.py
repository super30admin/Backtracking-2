class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        self.helper(nums,0,[])
        return self.result
    
    def helper(self,nums,i,path):
        #base
        if i==len(nums):
            self.result.append(path)
            return
        
        #nochoose
        self.helper(nums,i+1,path)
        #choose
        self.helper(nums,i+1,path+[nums[i]])