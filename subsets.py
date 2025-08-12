# Time Complexity: O(2^n)
# Space Complexity: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.recursive(nums, 0, [])
        return self.result

    def recursive(self, nums, index, path):
        self.result.append(list(path))
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.recursive(nums, i + 1, path)
            path.pop()




