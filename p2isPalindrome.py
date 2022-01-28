"""
Time: O(2N^2)
space: O(N) N = recursion height

backtracking, exhaust partition
"""

class Solution(object):
    def partition(self, s):
        res = []
        self.dfs(s, [], res)
        return res
    
    def dfs(self, s, path, res):
        if not s:
            res.append(path)
        for i in range(1, len(s)+1):
            if self.isPalindrome(s[:i]):
                self.dfs(s[i:], path+[s[:i]], res)
                 
    def isPalindrome(self, s):
        l, r = 0, len(s)-1
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1; r -= 1
        return True
		
	def isPalindrome1(self, s):
		return s == s[::-1]