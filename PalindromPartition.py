import copy
class Solution:
    def __init__(self):
        self.result=[]
    def partition(self, s: str) -> List[List[str]]:
        if s==None or len(s)==0:
            return self.result
        self.backtrack(s,[],0)
        return self.result
    
    def backtrack(self,s,temp,start):
        #base
        if start==len(s):
            li3 = copy.deepcopy(temp)
            self.result.append(li3)
        #logic
        for i in range(start,len(s)):
            if(self.palindrome(s,start,i)):
                #action
                temp.append(s[start:i+1])
                #recurse
                self.backtrack(s,temp,i+1)
                #backtrack
                temp.pop()
        
    def palindrome(self,s,l,r):
        while(l<=r):
            if s[l]==s[r]:
                l+=1
                r-=1
            else:
                return False
        return True
        
Time Complexity is O(2 raise to power n)
Space Complexity is O(n)
