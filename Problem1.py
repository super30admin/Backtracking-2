'''
Time Complexity: O(2^n)
Space Complexity: O(2^n)
Run on Leetcode: YES
'''
class Solution:
    def helper(self, nums: list[int], result: list[list[int]], path: list[int], index: int) -> None:
        #base
        if index == len(nums):
            result.append(path[:])
            return
        #logic

        #action
        self.helper(nums, result, path, index + 1)
        path.append(nums[index])
        #recurse
        self.helper(nums, result, path, index + 1)
        #backtrack
        path.pop()
        
    def subsets(self, nums: list[int]) -> list[list[int]]:
        result = []
        self.helper(nums, result, [], 0)
        return result