# Time Complexity : O(N*2^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(start, path):
            res.append(path[:])
            for i in range(start, len(nums)):
                path.append(nums[i])
                backtrack(i + 1, path)
                path.pop()
        backtrack(0, [])
        return res
        