# Time Complexity: O(2^n) n is the len of nums
# Space Complexity: O(n) for the recursion stack
# 01 Recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.helper(nums, 0, [],result)
        return result
    def helper(self, nums, idx, path, result):
        # Base
        if idx == len(nums):
            result.append(path[:]) # Make a copy of the path
            return
        # Logic
        # Don't choose case
        self.helper(nums, idx+1, path, result)
        # Choose case
        path.append(nums[idx])
        self.helper(nums, idx+1, path, result)
        path.pop()


# Time Complexity: O(2^n) n is the len of nums
# Space Complexity: O(n) for the recursion stack
# For Loop Recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.helper(nums, 0, [],result)
        return result
    def helper(self, nums, pivot, path, result):
        # Base
        # Logic
        result.append(path[:])
        for i in range(pivot, len(nums)):
            # action
            path.append(nums[i])
            # recurse
            self.helper(nums, i+1, path, result)
            # Bactrack
            path.pop()

# Time Complexity: O(2^n) n is the len of nums
# Space Complexity: O(n) for the recursion stack
# Without Recursion
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            new_subset = []
            for subset in result:
                new_subset.append(subset+[num])
            result.append(new_subset)
        return result