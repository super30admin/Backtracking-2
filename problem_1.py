# Time Complexity : O(2^n) --> exponential.
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# with-out using recursion
# TC: O(2^n); SC: O(n)
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = [[]]
        for i in range(len(nums)):
            for j in range(len(result)):
                temp = result[j][:]
                temp.append(nums[i])
                result.append(temp)
        return result


print(Solution().subsets([1, 2, 3]))


# for-loop based recursion
# Back-Tracking
# TC: O(2^n); SC: O(n)
# class Solution:
#     def helper(self, nums, index, path):
#         # base
#         if index == len(nums):
#             return
#         # logic
#         for i in range(index, len(nums)):
#             path.append(nums[i])
#             self.result.append(path[:])
#             self.helper(nums, i+1, path)
#             path.pop()
#
#     def subsets(self, nums: list[int]) -> list[list[int]]:
#         self.result = [[]]
#         self.helper(nums, 0, [])
#         return self.result
#
#
# print(Solution().subsets([1, 2, 3]))


# 01 Recursion
# Back-Tracking
# TC: O(2^n); SC: O(n)
# class Solution:
#     def helper(self, nums, index, path):
#         # base
#         if index == len(nums):
#             self.result.append(path[:])
#             return
#         # logic
#         # no choose
#         self.helper(nums, index+1, path)
#         # choose
#         path.append(nums[index])
#         self.helper(nums, index+1, path)
#         # Back-Track
#         path.pop()
#
#     def subsets(self, nums: list[int]) -> list[list[int]]:
#         self.result = []
#         self.helper(nums, 0, [])
#         return self.result
#
#
# print(Solution().subsets([1, 2, 3]))
