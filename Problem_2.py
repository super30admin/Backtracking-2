# Time Complexity: O(n * 2^n)
# Space Complexity: O(n * 2^n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        ans = []
        def isPalindrome(s):
            return s == s[::-1]
        def dfs(s, j, path, ans):
            if j == len(s):
                ans.append(path)
                return
            for i in range(j, len(s)):
                if isPalindrome(s[j: (i + 1)]):
                    dfs(s, (i + 1), (path + [s[j: (i + 1)]]), ans)
        dfs(s, 0, [], ans)
        return ans