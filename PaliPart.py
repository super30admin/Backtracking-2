#T(N)= O(N*2^N)
#S(N)= O(N)
class Solution:
    def pali(self,st):
        sta=0
        en=len(st)-1
        while sta<en:
            if st[sta]!=st[en]:
                return False
            sta+=1
            en-=1
        return True
    res=[]
    def helper(self,s,index,pa):
        #Base
        if index==len(s):
            self.res.append(pa[:])
            return
        
        #Logic
        for i in range(index,len(s)):
            sb=s[index:i+1]
            if(self.pali(sb)):
                pa.append(sb)
                self.helper(s,i+1,pa)
                pa.pop(-1)
            
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        if len(s)==1:
            return[[s]]
        self.helper(s,0,[])
        return self.res
        