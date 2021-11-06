class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []
        result = []
        
        def backtrack( nums, ind, path):
            # 
            #base
            if ind == len(nums):
                cop = list(path)
                result.append(cop)
                return
          
            #logic
            # Not choose
            backtrack(nums, ind +1 , path)
            
            path.append(nums[ind])
            # choose
            backtrack(nums, ind +1 , path)
            
            #backtrack
            path.pop()
        
        
        def recurse( nums, ind, path):
            #n * 2 ^n
       
            #logic
            result.append(path)
            # while( ind < len(nums)):
            for i in range(ind, len(nums)):
              
                cop = list(path)
                cop.append(nums[i])
                recurse(nums, i +1 , cop)
                
                
        # backtrack(nums, 0, [])   
        recurse(nums, 0, [])    
        return result
            
            
            
            
