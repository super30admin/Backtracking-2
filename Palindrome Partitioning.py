# Time Complexity : Exponential
# Space Complexity : 
# Did this code successfully run on Leetcode : YES


class Solution:
    def __init__(self):
        self.result = []
        
    def partition(self, s):
        if not s:
            return self.result
        temp = []
        self.backtrack(s, 0, temp)
        return self.result
    
    def backtrack(self, s, index, temp):
        #Base Case
        if index ==len(s):
            self.result.append(list(temp))
            return
        
        #Logic
        for i in range(index, len(s)):
            if self.isPalidrome(s, index, i):
                temp.append(s[index:i+1])               #String Slicing requires +1 to consider the last character
                self.backtrack(s, i+1, temp)
                #backtracking step by removing the last element
                temp.pop(-1)
    
    def isPalidrome(self, s, l, r):
        if l == r:
            return True
        while l < r:
            if s[l] != s[r]:
                return False
            else:
                l += 1
                r -= 1
        return True
    
    
        
        
