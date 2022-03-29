#2^n,n
#2^n,n
class Solution:
    def __init__(self):
        self.res=[]
    def partition(self, s: str) -> List[List[str]]:
        self.helper(s,0,"",[])
        return self.res
    def helper(self,s,index,path,tempres):
        #base
        
        if index== len(s):
            print(tempres)
            self.res.append(copy.copy(tempres))
            
            
            return
        #logic
        for i in range(index,len(s)):
            
            path=s[index:i+1]
            if self.ispalindrome(path):
               
                tempres.append(copy.copy(path))
                self.helper(s,i+1,path,tempres)
                tempres.pop()
            
    def ispalindrome(self,path):
        l=len(path)
        
        for i in range(1,(l//2)+1):
            
            if path[i-1]!=path[-i]:
                
                return False
        return True
            
            
        