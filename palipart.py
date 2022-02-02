# Time Complexity o(2^n)
# Space complexity o(n)
# Check evry substring for palindrome and return true if it is true



class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        res = []
        
        path = []
        
        
        
        
        def dfs(i):
            
            if i >= len(s):
                
                res.append(path.copy())
                print(path)
                return
            
            
            for j in range(i , len(s)):
                
                if self.ispali(s,i,j):
                    path.append(s[i:j+1])
                    dfs(j+1)
                    path.pop()
                    
        dfs(0)
        return res
    
    def ispali(self,s,l,r):
        
        while l <r:
            
            if s[l] != s[r]:
                return False
        
            l,r = l+1,r-1
        
        return True
        
            
                
        
        
        
        
        
        