# Time Complexity : O(n*2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        n = len(nums)

        def backtrack(start, cur):
            if len(cur) == i:
                output.append(cur.copy())
                return
            for j in range(start, n):
                cur.append(nums[j])
                backtrack(j+1, cur)
                cur.pop()
        for i in range(n+1):
            backtrack(0, [])
        return output
