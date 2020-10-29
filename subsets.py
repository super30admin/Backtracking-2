"""
Time - O(N * 2^N)
Space - O(N * 2^N)
Leetcode - yes
Problems - no
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        # nums = [1, 2, 3]
        results = []
        stack = []
                
        def recursion(nums, start, stack, results):
            
            if(len(stack) <= len(nums)):
                if list(stack) not in results:
                    results.append(list(stack))
            
            if(len(stack) > len(nums)):
                return 
            
            for i in range(start, len(nums)):
                stack.append(nums[i])
                recursion(nums, i+1, stack, results)
                stack.pop()
                
                
        recursion(nums, 0, stack, results)
        
        return results
        