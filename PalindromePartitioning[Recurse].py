"""
Time Complexity : O(N * 2^N) where N is no. of elements in an array
Space Complexity : O(N * 2^N) where N is no. of elements in an array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    result = []
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if not s:
            return []
        self.recurse(s, [])
        return self.result
    def recurse(self, s, path):
        # Base
        if len(s) == 0:
            self.result.append(path)
            return
        # Logic
        for i in range(len(s)):
            if self.isPalindrome(s, 0, i):
                newList = path + [s[0:i+1]]
                self.recurse(s[i+1:], newList)
    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True