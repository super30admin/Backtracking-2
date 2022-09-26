class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res=[]
        
        sub=[]
        
        def dfs(i):
            if i>=len(s):
                res.append(sub.copy())
                return
            
            for j in range(i,len(s)):
                if self.ispali(s,i,j):
                    #actions
                    sub.append(s[i:j+1])  
                    #recurse
                    dfs(j+1)
                    #backtrack
                    sub.pop()
        dfs(0)
        return res
    
    def ispali(self,s,l,r):
        while l<r:
            if s[l]!=s[r]:
                return False
            
            l,r=l+1,r-1
        
        return True