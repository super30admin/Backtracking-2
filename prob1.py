# Time Complexity :  O(2**n)
# Space Complexity :O(h)
# Passed on Leetcode: yes

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.path = []
        self.backtrack(nums, self.path, self.result, 0)
        return self.result

    def backtrack(self, nums, path, result, idx):
        # base
        if idx == len(nums):
            result.append(copy.deepcopy(path))
            return

        # logic

        # not choose
        self.backtrack(nums, path, result, idx+1)

        # choose
        # action
        path.append(nums[idx])
        self.backtrack(nums, path, result, idx+1)

        # backtrack
        path.pop()
