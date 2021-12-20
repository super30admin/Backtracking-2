# Tc O(2^n*n)
# sc O(n)
from typing import List
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        path=[]
        self.backtrack(0,s,path)
        return self.res
    def backtrack(self, index, s, path):
        if index==len(s):
            self.res.append(path[:])
            return
        for i in range(index,len(s)):
            if s[index:i+1]==s[index:i+1][::-1]:
                path.append(s[index:i+1])
                self.backtrack(i+1,s,path)
                path.pop()
        return