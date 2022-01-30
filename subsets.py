# tc :O(2^N) worse case
# sc :O(N) - as the maximum stack height is when there are single elements in recursion 
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        from copy import deepcopy
        result = []
        
        def recur(nums, index, subset):
            #BASE 
            if index == len(nums):
                result.append(deepcopy(subset)) # since subset is reference, we need copy
                return
            
            # LOGIC
            
            # choose index
            subset.append(nums[index])
            recur(nums, index+1, subset)
            subset.pop(-1) # backtrack the element
            
            # not choose index
            recur(nums, index+1, subset)
            
            
        
        recur(nums, 0, [])
        return result
        
