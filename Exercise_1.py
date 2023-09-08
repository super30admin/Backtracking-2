# ## Problem1
# Subsets (https://leetcode.com/problems/subsets/)
# // Time Complexity : O(2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

# S1: RQ
# S2: Constraints
# S3: Test Cases
# S4: Solution without Code
# 0-1 solution
# S5: Solution with Code


# For loop based Recursion using Backtracking
class Solution:
    def subsets(self, nums):
        # result list
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, pivot, path):
        self.result.append(list(path))
        for i in range(pivot, len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums, i + 1, path)
            # backtrack
            path.pop()

# // Space Complexity : O(n)
# Bactracking solution
# class Solution:
#     def subsets(self, nums):
#         # result list
#         self.result = []
#         self.helper(nums, 0, [])
#         return self.result

#     def helper(self, nums, i, path):
#         # base
#         if i == len(nums):
#             # creating a deep copy of path when adding to result so it doesnt get backtracked
#             self.result.append(list(path))
#             return
#         # logic
#         # not choose - case 0
#         self.helper(nums, i + 1, path)
#         # choose - case 1
#         # action
#         path.append(nums[i])
#         # recurse
#         self.helper(nums, i + 1, path)
#         # backtrack
#         path.pop()

# // Space Complexity : O(2^n)
# 0-1 solution
# class Solution:
#     def subsets(self, nums):
#         # result list
#         self.result = []
#         self.helper(nums, 0, [])
#         return self.result

#     def helper(self, nums, i, path):
#         # base
#         if i == len(nums):
#             appending path to final result
#             self.result.append(path)
#             return

#         # logic
#         # not choose - case 0
#         self.helper(nums, i + 1, list(path))
#         # choose - case 1
#         path.append(nums[i])
#         self.helper(nums, i + 1, list(path))


nums = [1, 2, 3]
sol = Solution()
print(sol.subsets(nums))
