# The subsets method generates all possible subsets of a given list of numbers.

# Backtracking Helper (dfs)
#   - If the index reaches the end of the list, append the current subset to the result.
#   - Include the current element in the subset and recursively explore further.
#   - Backtrack by removing the element and explore subsets without it.

# Return Result
#   - Call dfs starting from index 0 and return 'res', containing all subsets.

# TC: O(2^n) - Each element can be included or excluded, generating all subsets.
# SC: O(n) - Space for the recursion stack and the temporary subset.


from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        subset = []

        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return
            subset.append(nums[i])
            dfs(i + 1)
            subset.pop()
            dfs(i + 1)

        dfs(0)
        return res