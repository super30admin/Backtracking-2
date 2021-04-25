class Solution:
    result = []
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return
        
        self.helper(nums,0,[])
        
        return Solution.result
        
    def helper(self,nums,index,path):
        
        #base
        if index == len(nums):
            Solution.result.append(path.copy())
            return
      
        #logic
        #choose
        path.append(nums[index])
        self.helper(nums,index+1,path)
        path.pop()
        
        #dont choose
        self.helper(nums,index+1,path)
        
