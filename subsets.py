"""
Backtracking approach --
1. Traverse through the length of the list
2. Add first element and add combination of elements to create subsets
3. Backtrack, pop the 1st element and. Add second element and create combinations
4. Continue till the end of the list
5. Output when all combinations are added
TC - O(2^n)
SC - O(n)
"""


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(first=0, curr=[]):
            if len(curr) == k:
                output.append(curr[:])
                return
            for i in range(first, n):
                # append to curr
                curr.append(nums[i])
                # add first element and its combination
                backtrack(i + 1, curr)
                # pop first element from curr
                curr.pop()

        n = len(nums)
        output = []
        for k in range(n + 1):
            backtrack()
        return output