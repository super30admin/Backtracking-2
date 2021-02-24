'''
Time complexity: O(n * 2^n)
Space complexity: O(n)
'''
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.output = []
        if s is None or len(s) == 0:
            return self.output
        
        self.backtracking(s, 0, [])
        return self.output
    
    def backtracking(self, s, index, path):
        if index >= len(s):
            self.output.append(list(path))
            return
        
        for i in range(index, len(s)):
            curr = s[index:i+1]
            if self.isPallindrome(curr):
                path.append(curr)
                self.backtracking(s, i+1, path)
                path.pop()
                
    def isPallindrome(self, curr):
        left = 0
        right = len(curr) - 1
        
        while left < right:
            if curr[left] != curr[right]:
                return False
            left = left + 1
            right = right - 1
        return True
            
            
            