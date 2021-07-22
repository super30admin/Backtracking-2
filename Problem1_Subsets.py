# Time Complexity: O(2^n), where n is length of the input array
# Space Complexity: O(n),
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return []

        self.result = []
        self.dfs(nums, 0, [])
        return self.result

    def dfs(self, nums: List[int], index: int, path: List[int]) -> None:
        # base - when index goes out of bounds, add path to result and return
        if index == len(nums):
            self.result.append(list(path))
            return

        # logic
        # don't choose
        self.dfs(nums, index + 1, path)
        # choose
        path.append(nums[index])
        self.dfs(nums, index + 1, path)
        # backtrack
        path.pop()
