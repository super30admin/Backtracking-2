# Time Complexity: O(n * 2^n)
# Space Complexity: O(n * 2^n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        def dfs(s, path):
            ans.append(path)
            for i in range(s, len(nums)):
                dfs((i + 1), (path + [nums[i]]))
        dfs(0, [])
        return ans