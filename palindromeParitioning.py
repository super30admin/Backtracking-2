class Solution:
    # exhaustive recursive solution
    def isPalindrome(self,s,l,r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
    def recurse(self,s:str,idx:int,path:List[str]):
        # base
        if idx == len(s):
            print(path)
            self.res.append(path)
            return
        # logic for loop based recursion
        for i in range(idx,len(s)):
            if self.isPalindrome(s,idx,i):
                newpath = path[:]
                newpath.append(s[idx:i+1])
                self.recurse(s,i+1,newpath)
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        if s is None or len(s) == 0:
            return []
        self.recurse(s,0,[])
        return self.res
        
        