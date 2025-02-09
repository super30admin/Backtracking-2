#Time: O(n)
#space: O(h)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.final= list(list())
        self.backtrack(s,list(),0)
        return self.final

    def backtrack(self,s, path,index):
        if index == len(s):
            self.final.append(path.copy())
        
        for i in range(index, len(s)):
            st= s[index:i+1]
            if self.ispalindrome(st):
                path.append(st)
                self.backtrack(s,path,i+1)
                path.pop()
    
    def ispalindrome(self,st):
        l=0
        r= len(st)-1
        while(l <=r):
            if st[l] != st[r]:
                return False
            l +=1
            r -=1
        return True
        

        
