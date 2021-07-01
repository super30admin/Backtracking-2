# // Time Complexity : Exponential : O(2^n)
# // Space Complexity : O(n*2^n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Recursion Approach

class Solution:
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) == 0:
            return self.result
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):
        # base
        if index == len(nums):
            self.result.append(path)
            return

        # logic
        # Dont Choose
        self.helper(nums, index + 1, path.copy())

        # Choose
        path.append(nums[index])
        self.helper(nums, index + 1, path.copy())

# // Time Complexity : Exponential : O(2^n)
# // Space Complexity : O(n*2^n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Backtracking Approach

class Solution:
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) == 0:
            return self.result
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):
        # base
        if index == len(nums):
            self.result.append(path.copy())
            return

        # logic
        # Dont Choose
        self.helper(nums, index + 1, path)

        # Choose
        path.append(nums[index])
        self.helper(nums, index + 1, path)

        # backtrack
        path.pop()

