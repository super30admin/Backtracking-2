# Time Complexity: O(2^N)
# Space Complexity: O(N)

class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        self.find_subsets(nums, result, [], 0)
        return result

    def find_subsets(self, nums: list[int], result: list[list[int]], temp: list[int], i: int):
        if i >= len(nums):
            result.append(temp[:])
            return
        self.find_subsets(nums, result, temp, i + 1)
        temp.append(nums[i])
        self.find_subsets(nums, result, temp, i + 1)
        temp.pop()
