# Time Complexity : O(n * 2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use backtracking.
# At each index we have two choices, include the element or exclude it.
# Recursively explore both possibilities and add the subset when we reach
# the end of the array.


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def helper(i,arr):
            if i >= len(nums):
                self.res.append(arr[:])
                return 
            arr.append(nums[i])
            helper(i + 1,arr)
            arr.pop()
            helper(i + 1,arr)

        self.res = []
        helper(0,[])
        return self.res
        