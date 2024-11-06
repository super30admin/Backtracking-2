class Solution:
    def __init__(self):
        def __init__(self):
            self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, i, path):

        if i == len(nums):
            self.result.append(path.copy())
            return
        # no choose
        self.helper(nums, i + 1, path)
        # choose action
        path.append(nums[i])
        # recursive
        self.helper(nums, i + 1, path)
        # backtrack
        path.pop()


# time complexity is n*2^n
# space complexity is n*2^n


class Solution:

    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, pivot, path):

        self.result.append(path.copy())
        for i in range(pivot, len(nums)):
            # action
            path.append(nums[i])
            # self.result.append(path.copy())
            # recurse
            self.helper(nums, i + 1, path)
            # backtrack
            path.pop()


# time complexity is n*2^n
# space complexity is n*2^n


# without Recursion
class Solution:

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = [[]]
        for num in nums:
            size = len(self.result)
            for j in range(size):
                temp = self.result[j] + [num]
                self.result.append(temp)
        return self.result


# time complexity is n*2^n
# space complexity is n*2^n
