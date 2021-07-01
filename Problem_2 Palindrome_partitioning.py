# // Time Complexity : Exponential : O(n*2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Backtracking using Pivot Value
class Solution:
    def __init__(self):
        self.result = []

    def partition(self, s: str) -> List[List[str]]:
        if s == None or len(s) == 0:
            return self.result
        self.backtrack(s, [], 0)
        return self.result

    def backtrack(self, s, path, index):
        # base Case
        if index == len(s):
            self.result.append(path.copy())
            return
            # logic
            # each time we check if string formed by pivot and i is a palindrome,
            # then we proceed with that sequence
        for i in range(index, len(s)):
            if self.isPalindrome(s[index: i + 1]):
                #Action
                path.append(s[index: i + 1])
                #recurse
                self.backtrack(s, path, i + 1)
                #BackTrack
                path.pop()

    def isPalindrome(self, s):   # Checking if its a Palindrome
        left = 0
        right = len(s) - 1
        while (left <= right):
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True



