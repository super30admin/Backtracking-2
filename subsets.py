class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        
        subset=[]
        
        def dfs(i):
            if i>=len(nums):
                res.append(subset.copy())
                return
            
            #Choose Case
            #Action
            subset.append(nums[i])
            
            #Recuse
            dfs(i+1)
            
            #Backtrack
            subset.pop()
            
            #Not Choose
            dfs(i+1)
            
        dfs(0)    
        return res