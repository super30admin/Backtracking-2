"""
Complexity Analysis:

# Time Complexity: O(2^N) * O(N) --> Trying all possibilities + Copying paths to results array
# Space Complexity: O(N) --> Max Recursive Stack
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
    ### Iterative BackTrack
        result = []
        N = len(nums)
        
        def helper(index=0, path=[]):
            
            result.append(path.copy())
            
            for i in range(index,N):
                
                # Action
                path.append(nums[i])
                
                # Recurse
                helper(i+1,path)
                
                # BackTrack
                path.pop()
        
        helper()
        return result
                
        
        
    ### Recursive BackTrack        
        
#         result = []
#         N = len(nums)
        
#         def helper(index=0, path=[]):

#             ### Base Case
#             if index == N:
#                 result.append(path.copy())
#                 return

#             ### Don't Choose            
#             helper(index+1, path)
            
#             ### Choose
            
#             # Action
#             path.append(nums[index])
            
#             # Recurse
#             helper(index+1, path)
            
#             # BackTrack
#             path.pop()
            
#         helper()
#         return result