'''
Time Complexity: O(3^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a complete space of all possible combinations and backtrack whenever we reach  end of array
'''

import copy


class Solution:
    def backtrack(self, solution: List[int], nums: List[int], state: List[int], index: int):
        # we will never have repeated elements hence just add
        solution.append(copy.deepcopy(state))

        for i in range(index, len(nums)):
            # add candidate
            state.append(nums[i])
            # backtrack
            self.backtrack(solution, nums, state, i + 1)
            # pops elements and adds combination, last pop will be an empty array and start with a new subtree
            # pop
            state.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None:
            return []

        solution = []
        self.backtrack(solution, nums, [], 0)
        return solution