"""
Approach1: Normal Recursion
"""
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        if nums==0 or len(nums)==0:
            return self.result

        self.helper(nums,0,[])
        return self.result

    #Normal recursion and creating  path copy at every node
    def helper(self,nums,index,path):
        #base case
        if index==len(nums):
            self.result.append(path)
            return
        #logic
        #case1 Not to choose
        self.helper(nums,index+1,path.copy())
        #case2 Choose
        path.append(nums[index])
        self.helper(nums,index+1,path.copy())


s=Solution()
print(s.subsets([1,2,3]))

"""
Approach 2: Backtracking Way , here use the same path instead of creating new array list at every node
"""

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.result=[]
#         if nums==0 or len(nums)==0:
#             return self.result
#
#         self.helper(nums,0,[])
#         return self.result
#
#     #Normal recursion and creating  path copy at every node
#     def helper(self,nums,index,path):
#         #base case
#         if index==len(nums):
#             self.result.append(path.copy())
#             return
#         #logic
#         #case1 Not to choose
#         self.helper(nums,index+1,path)
#         #case2 Choose
#         path.append(nums[index])
#         self.helper(nums,index+1,path)
#
#         path.pop()