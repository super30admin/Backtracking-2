## Problem1
# Subsets (https://leetcode.com/problems/subsets/)

# Time Complexity : O(2^n) where n is the length of the nums array
# Space Complexity : O(n) where n is the length of the nums array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Backtracking
# 1. Start with an empty array and add it to the result
# 2. For each element in the nums array, add it to the temp array and add the temp array to the result
# 3. Recursively call the backtrack function with the temp array and the index of the element in the nums array
# 4. Remove the last element from the temp array and repeat the process for the next element in the nums array

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        if not nums:
            return result

        def backtrack(temp, index):
            result.append(temp[:])
            for i in range(index, len(nums)):
                temp.append(nums[i])
                backtrack(temp, i+1)
                temp.pop()

        backtrack([], 0)
        return result