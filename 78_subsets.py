'''

## Problem 78: subsets

## Author: Neha Doiphode
## Date:   08-03-2022

## Description:
    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

## Examples:
    Example 1:
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    Example 2:
        Input: nums = [0]
        Output: [[],[0]]

## Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.

## Approaches:
        1. Choose and not choose based recursive solution.
        2. Choose and not choose based backtracking solution.
        3. For loop based recursive solution.
        4. For loop based backtracking solution.
        5. Iterative solution.

## Time complexity = O(l * 2^l), where l is length of input list.
                     2^l to make recursive calls per step.
                     l to generate subset per step.
                     (Backtracking solution)

## Space complexity = O(l), space to maintain depth of recursion stack.

'''
from typing import List, Optional

def get_input():
    print("Enter integer elements of list(with spaces): ", end = "")
    l = input()
    l = [int(val) for val in l.split()]
    return l

class Solution:

    result = []

    def recursion(self, nums: List[int], combination: List[int], index: int) -> None:
        # base
        if index == len(nums):
            self.result.append(combination)
            return

        # logic
        # do not choose case
        self.recursion(nums, list(combination), index + 1)

        combination.append(nums[index])
        # choose case
        self.recursion(nums, list(combination), index + 1)

    def subsets_recursion(self, nums: List[int]) -> List[List[int]]:
        """
        Approach: Example = [1, 2, 3]

            1. not choose 1: [2, 3]
                2. not choose 2: [3]
                    3. not choose 3: []         -------------> Add to the result.
                    4.     choose 3: [3]        -------------> Add to the result.
                5. choose 2: [2]
                    6. not choose 3: [2]        -------------> Add to the result.
                    7.     choose 3: [2, 3]     -------------> Add to the result.

            8. choose 1: [1]                    -------------> Add to the result.
                9.  not choose 2: [3]
                    10. not choose 3: []
                    11.     choose 3: [1, 3]    -------------> Add to the result.
                12. choose 2:     [1, 2]        -------------> Add to the result.
                    13. not choose 3: [1, 2]
                    14. choose 3    : [1, 2, 3] -------------> Add to the result.


            result = [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
        """
        if len(nums) == 0:
            return []

        self.result = []
        combination = []
        index = 0

        self.recursion(nums, combination, index)
        return self.result

    def backtracking(self, nums: List[int], combination: List[int], index: int) -> None:
        # base
        if index == len(nums):
            self.result.append(list(combination))
            return

        # logic
        # do not choose case
        self.backtracking(nums, combination, index + 1)

        combination.append(nums[index])
        # choose case
        self.backtracking(nums, combination, index + 1)

        # backtrack
        combination.pop()


    def subsets_backtracking(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []

        self.result = []
        combination = []
        index = 0

        self.backtracking(nums, combination, index)
        return self.result

    def forloop_recursion(self, nums: List[int], combination: List[int], index: int) -> None:
        self.result.append(combination)
        for i in range(index, len(nums)):
            new_l = list(combination)
            new_l.append(nums[i])
            self.forloop_recursion(nums, new_l, i + 1)

    def subsets_forloop_recursion(self, nums: List[int]) -> List[List[int]]:
        """
        Approach: Example: [1, 2, 3]

                  We need a pivot element to start with. Initially pivot is 0.
                  []
                  [1], pivot = 0
                  [1, 2], pivot = 1
                  [1, 2, 3], pivot = 2
                  [1, 3], pivot 2
                  [2], pivot 1
                  [2, 3], pivot 2
                  [3], pivot 2
        """
        if len(nums) == 0:
            return []

        self.result = []
        combination = []
        index = 0

        self.forloop_recursion(nums, combination, index)
        return self.result

    def forloop_backtracking(self, nums: List[int], combination: List[int], index: int) -> None:
        self.result.append(list(combination))
        for i in range(index, len(nums)):
            combination.append(nums[i])
            self.forloop_backtracking(nums, combination, i + 1)
            combination.pop()

    def subsets_forloop_backtracking(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []

        self.result = []
        combination = []
        index = 0

        self.forloop_backtracking(nums, combination, index)
        return self.result


# Driver code
solution = Solution()
l = get_input()
print(f"Input list: {l}")
print(f"Approach 1: using recursion   : Subsets of list: {solution.subsets_recursion(l)}")
print(f"Approach 2: using backtracking: Subsets of list: {solution.subsets_backtracking(l)}")
print(f"Approach 3: using for loop based recursion   : Subsets of list: {solution.subsets_forloop_recursion(l)}")
print(f"Approach 4: using for loop based backtracking: Subsets of list: {solution.subsets_forloop_backtracking(l)}")
