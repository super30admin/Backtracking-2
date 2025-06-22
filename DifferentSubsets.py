from typing import Optional, List
import copy

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.res = []
#         def helper(nums, idx , path):
#             #base
#             if idx == len(nums):
#                 self.res.append(path[:])
#                 return

#             #logic
#             #not choose
#             helper(nums, idx+1, path) 
#             #choose
#             path.append(nums[idx])
#             helper(nums, idx+1, path)
#             path.pop()


#         helper(nums,0,[])
#         return self.res

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.res = []
#         def helper(nums, idx , path):
#             #base
#             if idx == len(nums):
#                 self.res.append(path[:])
#                 return

#             #logic
#             #choose
#             li = path[:]
#             li.append(nums[idx])
#             helper(nums, idx+1, li)
#             #not choose
#             helper(nums, idx+1, path) 

#         helper(nums,0,[])
#         return self.res

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.res = []
#         def helper(nums, pivot, path):
            
#             #need to add path in every step of for loop recursion and not only the leaves
#             self.res.append(path[:])
#             #logic
#             for i in range(pivot, len(nums)):
#                 path.append(nums[i])
#                 helper(nums, i+1, path)
#                 path.pop()

#         helper(nums,0,[])
#         return self.res

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.res = []
#         def helper(nums, pivot, path):
            
#             #need to add path in every step of for loop recursion and not only the leaves
#             self.res.append(path[:])
#             #logic
#             for i in range(pivot, len(nums)):
#                 li = path[:]
#                 li.append(nums[i])
#                 helper(nums, i+1, li)

#         helper(nums,0,[])
#         return self.res

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         res = []
#         res.append([])
#         for i in range(len(nums)):
#             for j in range(len(res)):
#                 li = res[j].copy()
#                 li.append(nums[i])
#                 res.append(li)
#         return res
        

# never mutate a ds that we are changing
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        res.append([])
        for i in range(len(nums)):
            size = len(res)
            for j in range(size):
                li = copy.deepcopy(res[j])
                li.append(nums[i])
                res.append(li)
        return res
        
        
        