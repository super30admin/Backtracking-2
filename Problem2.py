"""
// Time Complexity : o(2^n + n) = o(2^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution(object):
    
    def isPalindrome(self,s): #to check if given string is a palindrome or not
        if len(s) == 1: #string of length 1 is a palindrome in itself
            return True
        #pointers at beginning and end, for iteration
        l = 0
        h = len(s) - 1
        while l < h:
            if s[l] != s[h]:
                return False
            l = l+1
            h = h-1
            
        return True
            
    def helper(self, s, path, idx):
        
        if idx >= len(s): #append to res only if, the entire string has been traversed as entire string has to be partitioned
            self.res.append(path[:]) #copy of path
            
        for i in range(idx, len(s)):
            if self.isPalindrome(s[idx:i + 1]): #if substring is palindrome
                path.append(s[idx:i + 1]) #add to tmp list
                self.helper(s, path, i+1) #next index
                path.pop() #undo last step
            
        
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.res = []
        self.helper(s,[],0)
        return self.res