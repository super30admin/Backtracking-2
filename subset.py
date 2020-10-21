class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        
        def dfs(index=0,current=[]):
            
            if len(current) == k:
                subset.append(current[:])

            for i in range(index,len(nums)):
                current.append(nums[i])

                dfs(i+1,current)

                current.pop()
                
        subset = []
        
        for k in range(len(nums)+1):
            dfs()
            
        return subset
        
        