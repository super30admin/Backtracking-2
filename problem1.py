# https://leetcode.com/problems/subsets/
# Time Complexity : O(N x 2^N) where N is size of the input
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : One issue, fixed it


# Your code here along with comments explaining your approach in three sentences only

# Approach : This is a backtracking problem. We have to go through all the paths recursively and add them to the result.

from typing import List


class Solution:
    result: []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.backtracking(nums, 0, [])
        return self.result

    def backtracking(self, nums, start, level):
        self.result.append([i for i in level])

        for index in range(start, len(nums)):
            level.append(nums[index])
            self.backtracking(nums, index + 1, level)
            level.pop()

    # Iterative approach is we start with empty list [[]]
    # then we take the first item in nums and add it to all the elements in the previous lists [[], [1]]
    # second element in the list, [[], [1], [2], [1, 2]]
    # third element in the list, [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     result = [[]]
    #     for cur in nums:
    #         size = len(result)
    #         level = []
    #         for index in range(size):
    #             cur_level = result[index]
    #             level = [i for i in cur_level]
    #             level.append(cur)
    #             result.append(level)
    #     return result

    # Subsets with Bit Manipulation, where we use bits of an integers to create lists.
    # For example input is of size 2 then we can create 4 lists
    # 0, 1, 2, 3
    # 00, 01, 10, 11 -> corresponding indexes of nums are used to create list.

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     target = pow(2, len(nums))
    #     result = []
    #     for index in range(target):
    #         cur = bin(index)[2:]
    #         level = []
    #         size = len(cur) - 1
    #         while size >= 0:
    #             if cur[size] == '1':
    #                 idx = len(cur) - size - 1
    #                 level.append(nums[idx])
    #             size -= 1
    #         result.append( level)
    #     return result
