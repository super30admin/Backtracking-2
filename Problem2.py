## Problem2

# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s: return []
        n = len(s)
        def if_palindrome(sub):
            return sub == sub[::-1]
        
        res = []
    
        def dfs(start, path):
            if start == n:
                res.append(path.copy())
                return
            for i in range(start, n):
                if if_palindrome(s[start: i+1]):
                    path.append(s[start: i+1])
                    dfs(i+1, path)
                    path.pop()
              
        dfs(0, [])
        return res
        