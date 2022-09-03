'''
Time Complexity - O(2^n)
Space Complexity - O(n)
'''


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, i, path):
        if i == len(nums):
            self.result.append(list(path))
            return
        self.helper(nums, i+1, path)
        path.append(nums[i])
        self.helper(nums, i+1, path)
        path.pop()
