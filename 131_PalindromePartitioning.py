#  Time Complexity: O(2^n * n)
#  Space Complexity: O(2^n * n)

class Solution:
    result = []
    #For loop recursion     
    def partition(self, s: str):
        self.result = []
        if s == None or len(s) == 0:
            return
        self.helper(s,0,[])
        return self.result
    def helper(self,s,index,path):
        if index == len(s):
            self.result.append(path.copy())
        
        for i in range(index,len(s)):
            sub = s[index:(i+1)]
            if self.isPalindrome(sub):
                path.append(sub)
                self.helper(s,i+1,path)
                path.pop()
            
            
    def isPalindrome(self,s):
        return s == s[::-1]