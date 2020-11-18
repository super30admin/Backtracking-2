"""
Time complexity O(2^N)
Space complexity O(2^N)


Recursive
"""

class Solution_part_R:
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        if s is None or len(s)==0:
            return self.s
        temp=[]
        self.helper(s,temp,0)
        return self.res
    
    def helper(self,s,temp,pivot):
        #base
        if(pivot==len(s)):
            
            self.res.append(temp)
        
        #logic
        for i in range(pivot,len(s)):
            if self.ispalindrome(s,pivot,i):
                temp2=copy.deepcopy(temp)
                temp2.append(s[pivot:i+1])
                self.helper(s,temp2,i+1)
                
                
        
    def ispalindrome(self,s,l,r):
        if(l==r):
            return True
        while (l<r):
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True