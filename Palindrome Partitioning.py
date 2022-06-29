""""// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def isPalindrome(self, s):
        start = 0
        end = len(s) - 1
        while start <= end:
            if s[start] != s[end]:
                return False
            start = start + 1
            end = end - 1
        return True

    def helper(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(path[:])
            return

        # logic
        for i in range(index, len(s)):
            substring = s[index:i + 1]
            if not self.isPalindrome(substring):
                continue
            elif self.isPalindrome:
                path.append(substring)
                self.helper(s, i + 1, path)
                path.pop()


