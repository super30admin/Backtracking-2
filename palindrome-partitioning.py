# Time Complexity : O(n*2^n) - n is the len(s)
# Space Complexity : O(n*2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Recursion
"""


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, start, path):
        if start == len(s):
            self.result.append(list(path))

        for i in range(start, len(s)):
            if self.isPalindrome(s, start, i):
                path.append(s[start:i + 1])
                self.helper(s, i + 1, path)
                path.pop()

    def isPalindrome(self, s, start, end):
        if start == end:
            return True

        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True

