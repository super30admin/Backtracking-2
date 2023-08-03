class Solution:
    # Time Complexity:2^n
    # Space Complexity:O(n)
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if not nums:
            return self.result
        self.helper(nums, 0, path=[])
        return self.result

    def helper(self, nums, pivot, path):
        self.result.append(list(path))
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(nums, i + 1, path)
            path.pop()
