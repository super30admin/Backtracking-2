class Solution:
    def __init__(self):
        self.result = []

    """
    Recursive approach
    TC - O(n*2^n)
    SC - O(n)
    """

    def approach1(self, nums, index, path):
        if index == len(nums):
            self.result.append(path)
            return
        self.approach1(nums, index + 1, path.copy())
        path.append(nums[index])
        self.approach1(nums, index + 1, path.copy())

    """
    Backtracking approach
    TC - O(n*2^n)
    SC - O(n)
    """

    def approach2(self, nums, index, path):
        if index == len(nums):
            self.result.append(path.copy())
            return
        self.approach2(nums, index + 1, path)
        path.append(nums[index])
        self.approach2(nums, index + 1, path)
        path.pop()

    """
    Backtrack approach with another loop template
    Backtracking approach
    TC - O(n*2^n)
    SC - O(n)
    """

    def approach3(self, nums, index, path):
        if index == len(nums):
            self.result.append(path.copy())
            return

        self.result.append(path.copy())
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.approach3(nums, i + 1, path)
            path.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        self.approach3(nums, 0, [])
        return self.result