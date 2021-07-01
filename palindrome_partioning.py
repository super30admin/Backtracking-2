class Solution(object):
    res=[]
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
       
        :TC:O(2^n)
        """
        # if not s: return []
        
        self.backtrack(s, [])
        return self.res
    
    def backtrack(self, s,  path):
        # base
        if len(s)==0:
            cp=path[:]
            self.res.append(cp)
            return
        
        
        # logic
        for i in range(len(s)):
            # check if child is palidropmic 
            if self.isPald(s,0,i):
                # action
                path.append(s[:i+1])
                # recurse
                self.backtrack(s[i+1:], path)
                # backtrack
                path.pop()
                
                
    def isPald(self, s, l, r):
        while l<r:
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        
        return True