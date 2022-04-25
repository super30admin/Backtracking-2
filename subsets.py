class Solution:
    
    def RecurrsiveSolutionsubsets(self, nums: List[int]) -> List[List[int]]:
        
        def helper( nums, idx, path  ):
          
            if not nums or idx >= len(nums):
                result.append( path )
                return
                
            helper( nums, idx+1 , path  )
            newList = list(path)
            newList.append( nums[idx]  )
            helper( nums, idx+1 , newList  )
        result = [] 
        helper( nums, 0, []  )
        return result
    
    
    def BacktrackingSolutionsubsets(self, nums: List[int]) -> List[List[int]]:
        
        '''
        T = O( N*(2^N) )
        S = O(N)
        '''
        
        
        def helper( nums, idx, r  ):
            # print(r)
            result.append(list(r))
            if idx >= len(nums):
                # result.append(list(r))
                return
            
            for i in range(  idx ,   len(nums)):
                r.append(nums[i])
                helper( nums, i+1 , r )
                r.pop()
                
            
        result = [ ]
        helper( nums, 0, [] )
        return result
    
    
    
    
    
    
    
