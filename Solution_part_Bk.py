"""
Time complexity O(2^N)

Backtrack 
"""

class Solution_part_Bk:
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        if s is None or len(s)==0:
            return self.s
        temp=[]
        self.backtrack(s,temp,0)
        return self.res
    
    def backtrack(self,s,temp,pivot):
        #base
        if(pivot==len(s)):
            temp1=copy.deepcopy(temp)
            self.res.append(temp1)
        
        #logic
        for i in range(pivot,len(s)):
            if self.ispalindrome(s,pivot,i):
                temp.append(s[pivot:i+1])
                self.backtrack(s,temp,i+1)
                temp.pop()
                
        
    def ispalindrome(self,s,l,r):
        if(l==r):
            return True
        while (l<r):
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True