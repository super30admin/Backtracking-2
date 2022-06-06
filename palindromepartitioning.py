#Time Complexity: Exponential
#Space Complexity: Exponential
class Solution:
    result = []
    
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        
        self.helper(s,0,[])
        
        
        return self.result
    
    def helper(self,s,idx,path):
        if idx == len(s):
            self.result.append(path.copy())
            return
        
        for i in range(idx,len(s)):
            st = s[idx:i+1]
            if self.isPalindrome(st):
                path.append(st)
                self.helper(s,i+1,path)
                path.pop()
                
                
    def isPalindrome(self,st):
        return st == st[::-1]
                
            
        
        
        