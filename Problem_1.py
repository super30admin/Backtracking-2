"""
Time Complexity : O(2^n)
Space Complexity : O(1) for temp array and O(n) for recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
I have 3 codes below. The first one is backtracking using for loop. The second is backtrack without for loop
and the third is normal recursion. Backtracking is action , recurse and backtrack. In recursion, the solution
consumes a lot of space as a temp array is made at every node, which increases the space exponentially.
With backtracking, we use the same list for whole recursion and keep on removing the value once recursion at
that point is done.
"""


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return nums
        self.result = []
        self.helper(nums, 0, [], len(nums))
        return self.result

    def helper(self, nums, index, temp, l):
        newtemp = copy.deepcopy(temp)
        self.result.append(newtemp)
        for i in range(index, l):
            temp.append(nums[i])
            self.helper(nums, i+1, temp, l)
            temp.pop()

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         if not nums:
#             return nums
#         self.result=[]
#         self.helper(nums,0,[])
#         return self.result

#     def helper(self,nums,index,temp):
#         if index==len(nums):
#             newtemp=copy.deepcopy(temp)
#             self.result.append(newtemp)
#             return
#         self.helper(nums,index+1,temp)
#         temp.append(nums[index])
#         self.helper(nums,index+1,temp)
#         temp.pop()

# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         if not nums:
#             return nums
#         self.result=[]
#         self.helper(nums,0,[])
#         return self.result

#     def helper(self,nums,index,temp):
#         if index==len(nums):
#             self.result.append(temp)
#             return
#         self.helper(nums,index+1,temp)
#         self.helper(nums,index+1,temp+[nums[index]])
