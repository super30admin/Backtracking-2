# O(n*2^n) time and space
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
        
#         # Backtracking choose not choose recursion 
#         # Brute force would be similar without backtrack step and we would crete new list for path on each recursive call
#         result = []
        
#         def helper(nums,i,path):
#             #Base
#             if i == len(nums):
#                 result.append(list(path))
#                 return
#             # Logic
#             # Don't Choose
#             helper(nums,i+1,path)
#             #Choose
#             path.append(nums[i])
#             helper(nums,i+1,path)
#             #BAcktrack
#             path.pop()
            
        
#         helper(nums,0,[])
#         return result

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
        
#         # Backtracking for-loop based recursion O(n*2^n) time and space
#         # Brute force would be similar without backtrack step and we would crete new list for path on each recursive call
#         result = []
        
#         def helper(nums,idx,path):
#             #Base
#             # Logic
#             result.append(list(path))
#             for i in range(idx,len(nums)):
#                 path.append(nums[i])
#                 print(path)
#                 helper(nums,i+1,path)
#                 #Backtrack
#                 path.pop()
            
        
#         helper(nums,0,[])
#         return result

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Iterative solution
        
        result = []
        result.append([])
        
        for i in range(len(nums)):
            size = len(result) # For restricting the second for loop.
            # NOTE: We need not do this in Python as len() function in Python under the hood when we run it len() will take the initial size only even if the array size changes
            # for j in range(size):
            for j in range(len(result)):
                temp = list(result[j])
                temp.append(nums[i])
                result.append(temp)
        return result