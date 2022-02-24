# Time complexity: Exponential = 2^n
# Space complexity: O(n)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []

        if nums is None or len(nums) == 0:
            return self.result
        path = []

        self.helper(nums, 0, path)
        return self.result

    def helper(self, nums, index, path):
        # base case

        # logic
        self.result.append(path.copy())

        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i + 1, path)
            path.pop()


