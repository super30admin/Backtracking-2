class Solution:
    def __init__(self):
        self.result=[]
    def subsets(self, nums: List[int]) -> List[List[int]]:
        arr=[]
        self.helper(nums, arr)
        return self.result
    
    def helper(self, nums, arr):
        self.result.append(arr)
        for i in range(len(nums)):
            size=len(self.result)
            for j in range(size):
                copy=self.result[j].copy()
                copy.append(nums[i])
                self.result.append(copy)
                
                
                
            
    """Using for loop, backtracking and recursion"""
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         arr=[]
#         self.helper(nums, arr, 0)
#         return self.result
    
#     def helper(self, nums, arr, index):
#         self.result.append(arr[:])
#         for i in range(index,len(nums)):
#             copy=arr[:]
#             copy.append(nums[i])
#             self.helper(nums, copy, i+1)
#             copy.pop()
        
    """Backtracking
    Time Complexity-O(2^n)
    Space complexity-O(n)"""
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         arr=[]
#         self.helper(nums, arr, 0)
#         return self.result
    
#     def helper(self, nums, arr, index):
#         if index==len(nums):
#             self.result.append(arr[:])
#             return
        
#         self.helper(nums, arr, index+1)
#         arr.append(nums[index])
#         self.helper(nums, arr, index+1)
#         arr.pop()
    """Recursive approach
    Time Complexity-2n*O(2^n)~O(2^n)
    Space complexity-O(2^n)"""
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         arr=[]
#         self.helper(nums, arr, 0)
#         return self.result
    
#     def helper(self, nums, arr, index):
#         if index==len(nums):
#             self.result.append(arr)
#             return
#         copy=arr[:]
#         copy.append(nums[index])
#         self.helper(nums, copy[:], index+1)
        
#         self.helper(nums, arr[:], index+1)
#         # arr.append(nums[index])
#         # self.helper(nums, arr[:], index+1)
        
        