#time: O(n2^n)
#space: O(n)

class Solution:
    result=[]
    def partition(self, s: str) -> List[List[str]]:
        if(s==None or len(s)==0):
            return []
        self.result=[]
        path=[]
        self.helper(s,0,path)
        return self.result
    
    def helper(self,s,index,path):
        if(index>=len(s)):
            newpath=[]+path
            self.result.append(newpath)
            return
        for j in range(len(s)-index):
    
            if(self.palindrome(s,index,index+j)):
                string=s[index:index+j+1]
                self.helper(s,index+1+j,path+[string])
                
            
        
        
        
    def palindrome(self,string,l,r):
        if(l==r):
            return True
        while(l<=r):
            if(string[l]!=string[r]):
                return False
            else:
                l+=1
                r-=1
        return True
            
        
        
        
    
        
        