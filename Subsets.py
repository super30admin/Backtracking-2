# Time Complexity : O(2^n)
# Space Complexity : O(length of nums array)

# The code ran on LeetCode

# Start the pivot from index 0 and move it to right. At every point, we can either choose or not choose the value in the pivot to create a subset. When the pivot crosses the length of nums, append it to the result.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        res = []

        def helper(nums, path, idx):
            nonlocal res
            # Base
            if idx == len(nums):
                copy = [p for p in path]
                res.append(copy)
                return
            # Dont choose
            helper(nums, path, idx+1)
            # Choose
            path.append(nums[idx])
            # Recurse
            helper(nums, path, idx+1)
            # Backtrack
            path.remove(path[-1])

            
        helper(nums, [], 0)
        return res