from copy import copy
"""
Approach: Do a DFS traversal and decide if the element of the array needs to used in your result

TC: O(n * 2^n)
SC: O(n * 2^n)
"""

class Solution:
    # approach 1: recursion
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):
        # base
        if index == len(nums):
            return self.result.append(path)

        # logic
        # not choose
        self.helper(nums, index + 1, path)

        # choose
        path_copy = deepcopy(path)
        path_copy.append(nums[index])
        self.helper(nums, index + 1, path_copy)

"""
Approach: add the candidate, traverse in DFS manner and remove the candidate

TC: O(2^n)
SC: O(n)
"""
    # approach 2: backtracking
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.backtrack(nums, 0, [])
        return self.result

    def backtrack(self, nums, index, path):
        # base
        if index == len(nums):
            self.result.append(deepcopy(path))
            return

        # logic
        # not choose
        self.backtrack(nums, index + 1, path)

        # choose
        path.append(nums[index])
        self.backtrack(nums, index + 1, path)
        path.pop()

    # approach 3: without recursion
    """
    Approach: start with empty list and generate candidates by adding new elements to the previous list
    
    TC: O(n * 2^n)
    SC: O(n*n) as at each node you'd create a temp list
    """
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        n = len(nums)
        for i in range(n):
            size = len(result)
            for j in range(size):
                temp = deepcopy(result[j])
                temp.append(nums[i])
                result.append(temp)
        return result

