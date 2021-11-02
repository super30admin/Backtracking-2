# // Time Complexity : O(n*2^n) where n is the length of the nums array 
# // Space Complexity : O(n)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.backtrack(s,[],0)
        return self.res
    
    def isPalindrome(self,s):
        s_dash = s[::-1]
        if s == s_dash: return True
        return False
    
    def backtrack(self,s,temp,start):
        if start == len(s):
            self.res.append(list(temp))
            return
        
        string = ''
        
        for i in range(start,len(s)):
            string += s[i]
            if self.isPalindrome(string):
                temp.append(string)
                self.backtrack(s,temp,i+1)
                temp.pop()
        