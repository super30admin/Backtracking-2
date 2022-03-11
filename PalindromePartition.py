# // Time Complexity : O(n*2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def partition(self, s: str):
        
        res = []
        part = []
        
        def dfs(i):
            
            # base case
            if i >= len(s):
                res.append(part.copy())
                return 
            
            # checks for palindrome recursively and adds to partition list
            for j in range(i, len(s)):
                if self.isPali(s, i, j):
                    part.append(s[i:j+1])
                    dfs(j+1)
                    part.pop()
                    
        dfs(0)
        return res
    
    # helper to check palindrome
    def isPali(self, s, l, r):
        while l<=r:
            if s[l] != s[r]:
                return False
            l, r = l+1, r-1
        return True
        