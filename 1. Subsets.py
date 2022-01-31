class Solution:
    # Time Complexity - O(n * 2^n)
    # Space Complexity - O(n)
    def subsets(self, nums):
        result = []
        self.dfs(nums, [], result)
        return result

    def dfs(self, nums, subset, result):
        # print(subset)
        result.append(subset)
        for i in range(len(nums)):
            print(nums[i])
            self.dfs(nums[i + 1:], subset + [nums[i]], result)