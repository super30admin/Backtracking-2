"""
Problem: 78. Subsets
Leetcode: https://leetcode.com/problems/subsets/
Solution: Backtracking
Time complexity: O(N^2 *N) to generate all subsets and then copy them into output list.
Space complexity: O(N^2 *N) to keep all the subsets of length N, since each of N elements could be present or absent.
Does this code run on Leetcode: Yes
"""


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        path = []

        self.backtracking(output, nums, 0, path)
        return output

    def backtracking(self, output, nums, index, path):
        # base case
        output.append(deepcopy(path))

        # recursive case
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.backtracking(output, nums, i + 1, path)
            path.pop()








