'''
Time Complexity: 0(2^n) 
Space Complexity: Recursion Stack 0(n)
'''

class Solution:
    result = list()
    def partition(self, s: str) -> List[List[str]]:
        self.result = list()
        
        if s == '' or len(s) == 0:
            return self.result
        
        self.helper(s, 0, [])
        return self.result
        
    
    def helper(self, s, index, path):
        if index == len(s):
            self.result.append(path.copy())
            return
        
        for i in range(index, len(s)):
            substr = s[index:i+1]
            if self.ispalindrome(substr):
                path.append(substr)
                self.helper(s, index+len(substr), path)
                path.pop()
            
            
    
    def ispalindrome(self, s):
        l = 0
        r = len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True