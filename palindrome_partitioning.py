# Time Complexity: O(n * 2^n) we have to check the string everytime for palindrome everytime
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        if not len(s):
            return self.res
        self.backtrack(s, 0, [])
        return self.res
    
    def backtrack(self, s, index, path):
        if len(s) == index:
            self.res.append(path.copy())
            return
        
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                path.append(s[index: i + 1])
                self.backtrack(s, i + 1, path)
                path.pop()
                
    def isPalindrome(self, s, l, r):
        if l == r:
            return True
        while l <= r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
        