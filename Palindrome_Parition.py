class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        partition=[]
        
        def is_palindrome(s,i,j):
            while i<j:
                if s[i]!=s[j]:
                    return False
                
                i,j=i+1,j-1
                
            return True
        
        def dfs(index):
            if index>=len(s):
                result.append(partition[:])
                return
            
            for j in range(index,len(s)):
                if is_palindrome(s,index,j):
                    partition.append(s[index:j+1])
                    dfs(j+1)
                    partition.pop()
                    
        dfs(0)
         
            
        return result