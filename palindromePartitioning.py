"""
Time Complexity : O(n*2^n)
Space Complexity : combinationSum() - O(1)
                                     [O(h) - stack space, where h is the maximum depth of recursion]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class Solution:
    def partition(self, s):
        res = []
        if not s or len(s) == 0:
            return res
        res = self.backtrack(s, 0, [], res)
        return res
        
    def backtrack(self,s, index, temp, res):
        # base case
        if index == len(s):
            res.append(temp.copy())
            return res
        
        # recursive case
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                temp.append(s[index:i+1])
                res = self.backtrack(s, i+1, temp, res)
                temp.pop()
        return res
    
    def isPalindrome(self, s, l, r):
        if l == r:
            return True
        while l < r:
            if s[l] == s[r]:
                l += 1
                r -= 1
            else:
                return False
        return True