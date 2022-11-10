# TC: O(N) total number of subsets and then checking if they are palindrone or not
# SC: O(N) total number of subsets created

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        output=[]
        res1=[]
        def backtrack(i):
            if i>=len(s):
                output.append(res1.copy())
                        
            for j in range(i,len(s)):
                if self.palindrone(i,j,s):
                    res1.append(s[i:j+1])
                    backtrack(j+1)
                    res1.pop()
    
        backtrack(0)
        return output
        
    def palindrone(self,l,r,s):
        while l<=r:
            if s[l]==s[r]:
                l+=1
                r-=1
            else:
                return False
        return True
            
        