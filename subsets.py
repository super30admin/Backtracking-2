class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def helper(temp, index):
            #base
            
            
            #logic
            for i in range(index, len(nums)):
                #action
                temp.append(nums[i])
                res.append(temp.copy())
                #recursion
                helper(temp, i+1)
                
                #Backtrack
                temp.pop()
    
        
        res = []
        temp = []
        res.append(temp)
        helper(temp, 0)
        
        return res
            
            
        
        