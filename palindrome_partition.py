# Time Complexity : Add - O(n*2^n)
# Space Complexity :O(n*2^n) - including recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used backtracking to add different subset to the list only if it is palindrome

'''
class Solution:
    result = []
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if not s or len(s) < 1:
            return self.result
        
        self._backtrack(s, [], 0)
        
        return self.result
        
        
    def _backtrack(self, s, path, index):
        
        if index == len(s):
            self.result.append(path[:])
            return
        
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                
                path.append(s[index:i+1])
                
                self._backtrack(s, path, i+1)
                
                _ = path.pop()
            
    
    def isPalindrome(self, s, l, r):
        
        if l == r:
            return True
        
        while l <= r:
            if s[l] == s[r]:
                l += 1
                r -= 1
            else:
                return False
        return True
            