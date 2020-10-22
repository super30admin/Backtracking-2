# Time Complexity: O(N*2^N)
# Space Complexity: O(N*2^N)
# Yes, it ran on Leetcode
# No problems

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        ans = []
        self.helper(s,ans,[])
        return ans
    
    def helper(self,s,ans,path):
        if not s:
            ans.append(path)
        for i in range(1,len(s)+1):
            if self.palin(s[:i]):
                self.helper(s[i:],ans,path+[s[:i]])         

    def palin(self,st):
        if st==st[::-1]:
            return True
        else:
            return False