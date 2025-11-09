# 131. Palindrome Partitioning

# Time Complexity: O(n*2^n)
# Space Complexity: O(n)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = list()

        self.helper(s, 0, list(), result)
        return result
    
    def helper(self, s, idx, path, result):
        # Base
        if idx == len(s):
            result.append(list(path))
            return
        
        # Logic
        for i in range(idx, len(s)):
            if self.isPalindrome(s, idx, i):
                path.append(s[idx:i+1])
                self.helper(s, i+1, path, result)
                path.pop()
        
    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
