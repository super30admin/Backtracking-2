# Time Complexity : O(2^n), where n is the number of elements in nums
# Space Complexity : O(n), for recursion stack in backtracking
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# I used backtracking to generate all combinations by including or excluding each element

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(index, path):
            result.append(path[:])
            for i in range(index, len(nums)):
                path.append(nums[i])
                backtrack(i + 1, path)
                path.pop()

        backtrack(0, [])
        return result
