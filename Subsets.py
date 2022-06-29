# Without Recursion
""""// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        for i in range(len(nums)):
            size = len(result)
            for j in range(size):
                li = result[j][:]
                li.append(nums[i])
                result.append(li)
        return result

# for loop recursion back-tracking
""""// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums, 0, [])
#         return self.result
#     def helper(self, nums, index, path):
#         #base

#         #logic
#         self.result.append(path[:])
#         for i in range(index, len(nums)):
#             path.append(nums[i])
#             self.helper(nums, i+1, path)
#             path.pop()

# for loop brute-force
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums, 0, [])
#         return self.result
#     def helper(self, nums, index, path):
#         #base

#         #logic
#         self.result.append(path)
#         for i in range(index, len(nums)):
#             li=path[:]
#             li.append(nums[i])
#             self.helper(nums, i+1, li)


# 01 backtracking
""""// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums, 0, [])
#         return self.result
#     def helper(self, nums, index, path):
#         #base
#         if index == len(nums):
#             self.result.append(path[:])
#             return

#         #logic
#         #no choose
#         self.helper(nums, index+1, path)

#         #choose
#         path.append(nums[index])
#         self.helper(nums, index+1, path)
#         path.pop()

# 01 brute force no choose and then choose
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums, 0, [])
#         return self.result
#     def helper(self, nums, index, path):
#         #base
#         if index == len(nums):
#             self.result.append(path)
#             return

#         #logic
#         #no choose
#         self.helper(nums, index+1, path[:])

#         #choose
#         path.append(nums[index])
#         self.helper(nums, index+1, path[:])
#         # path.pop()

# 01 brute force choose and then no choose
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.helper(nums, 0, [])
#         return self.result
#     def helper(self, nums, index, path):
#         #base
#         if index == len(nums):
#             self.result.append(path)
#             return

#         #logic

#         #choose
#         li=path[:]
#         li.append(nums[index])
#         self.helper(nums, index+1, li)
#         #no choose
#         self.helper(nums, index+1, path[:])


#         # path.pop()