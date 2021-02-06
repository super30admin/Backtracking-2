#Time COmplexity:O(exponential)
#Space Complexity:O(exponential)

class Solution:
    global result
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        if len(s)==0:
            return self.result
        self.backtrack(s,0,[])
        return self.result
    
    def backtrack(self,s:str,idx:int,path:List[str])->None:
        if idx==len(s):
            self.result.append(path.copy())
            return
        for i in range(idx,len(s)):
            if self.isPalindrome(s,idx,i):
                path.append(s[idx:i+1])
                self.backtrack(s,i+1,path)
                path.pop()
    
    def isPalindrome(self,s:str,l:int,r:int)->bool:
        if l==r:
            return True
        while(l<r):
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True