#Time complexity: exponential
#Space complexity: exponential
from collections import List
class Solution:
    res=[]
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        self.helper(s,0,[])
        return self.res
        
    def helper(self,s,index,path):
        if index==len(s):
            self.res.append(path.copy())
        for i in range(index,len(s)):
            sub_s=s[index:i+1]
            if self.palindrome(sub_s):
                path.append(sub_s)
                self.helper(s,i+1,path)
                path.pop()
    
    def palindrome(self,s):
        return s==s[::-1]
                    
        