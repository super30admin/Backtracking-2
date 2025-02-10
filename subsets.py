"""

Given an integer array nums of unique elements, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.


Time Complexity: O(2^n), as each element has two choices (include or exclude), leading to 2^n subsets.
Space Complexity: O(n) for the recursion stack, plus O(2^n * n) for storing all subsets, so overall O(2^n * n).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# Approach:
# used a recursive Depth-First Search (DFS) to explore all subsets by either including or excluding each element. 
# At each step, we append the current subset to the result and recurse further before backtracking. 
# This ensures we generate all possible subsets of the given list.


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        res = []
        subset = []

        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return

            # when including nums[i]
            subset.append(nums[i])
            dfs(i+1)

            # when NOT including nums[i]
            subset.pop()
            dfs(i+1)

        dfs(0)

        return res


```
