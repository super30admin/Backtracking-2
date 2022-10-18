#palindrome partitioning
#Time complexity:O(2^N)
#space:O(N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        current = []
        
        def dfs(i):
            #base case
            if i >=len(s):
                res.append(current.copy())
                return
            for j in range(i,len(s)):
                if self.ispali(s,i,j):
                    current.append(s[i:j+1])
                    dfs(j+1)
                    current.pop()
        dfs(0)
        return res
    #helper    
    def ispali(self,s,l,r):
        while l<r:
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True
        