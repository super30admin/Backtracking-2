class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def backtrack(nums, index, subset):
            
            if index == len(nums):
                result.append(subset)
                return
                
            backtrack(nums, index + 1, subset.copy())
            
            subset.append(nums[index])
            
            backtrack(nums, index + 1, subset.copy())
            
        result = []
        backtrack(nums, 0, [])
        return result
    
    # This is recursive solution
    # Time Complexity: O(N x 2^N)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def backtrack(nums, index, subset):
            
            result.append(subset.copy())
                
                
            for i in range(index, len(nums)):
                subset.append(nums[i])
                backtrack(nums, i + 1, subset)
                subset.pop()
            
        result = []
        backtrack(nums, 0, [])
        return result
    
    # This is recursive solution
    # Time Complexity: O(N x 2^N)