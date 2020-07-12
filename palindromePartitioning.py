# Time Complexity : O(n*2^n), where n is the length of s
# Space Complexity : O(n), only one list used.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# this approach uses backtracking where substrings are created and checked if palindrome.
# the substrings are created by keeping track of the index.
class Solution(object):
    def __init__(self):
        self.retVal = []

    def partition(self, s):
        if not s:
            return self.retVal

        self.backtrack(s, 0, [])
        return self.retVal

    def backtrack(self, s, idx, temp):
        if idx == len(s):
            self.retVal.append(list(temp))
        # iterate
        for i in range(idx, len(s)):
            if self.isPalindrome(s, idx, i):
                # action
                temp.append(s[idx:i + 1])
                # recurse
                self.backtrack(s, i + 1, temp)
                # backtrack
                temp.pop()

    def isPalindrome(self, s, left, right):
        if left == right:
            return True

        while left < right:
            if s[left] != s[right]:
                return False

            left += 1
            right -= 1

        return True
