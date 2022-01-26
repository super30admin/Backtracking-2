# Time Complexity : 2 ^ (N)
# Space Complexity : O(N) deepest recursion tree will be to build the subset that has all the elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        def recur(start, combi):
            nonlocal result
            # base case
            if start == len(nums):
                return
            # logic
            for i in range(start, len(nums)):
                combi.append(nums[i])
                result.append(combi[:]) #every combi you make has to be added to your result
                recur(i + 1, combi)
                combi.pop()

        recur(0, [])
        return result