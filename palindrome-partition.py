"""
131. Palindrome Partitioning


Time = O(n*2^n) where n = length of the string
space = O(n)
Successfully excecuted on leetcode

Approach:
1. DFS + recursion(Backtracking)
2. At each step for given string -> append the s[i] check if it's palindeomr and keep iterating till the last element
"""

class Palindrome:
    
    def partition(self, s):
        res = []
        self.dfs(s, [], res)
        return res

    def dfs(self, s, path, res):
        if not s: # backtracking
            res.append(path)
        for i in range(1, len(s)+1):
            if self.isPalindrome(s[:i]):
                self.dfs(s[i:], path+[s[:i]], res)

    def isPalindrome(self, s):
        return s == s[::-1]