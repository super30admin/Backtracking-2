#TC-o(n*2^n)
#SC-o(n)

class Solution:
    
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        if((len(s)==0) or (s==None)):
            return res
        self.backtrack(s,0,[])
        return self.res
        
        
        
        
    def backtrack(self,s,index,temp):
        #base
        if(index==len(s)):
            self.res.append(list(temp))
            return
        
        
        #logic
        for i in range(index,len(s)):
            if(self.palindrome(s,index,i)):
                temp.append(s[index:i+1])
                self.backtrack(s,i+1,temp)
                temp.pop(-1)
                
                
    def palindrome(self,s,l,r):
        while(l<r):
            if(s[l]!=s[r]):
                return False
            l+=1
            r-=1
        return True
        
        
