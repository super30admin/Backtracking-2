import copy
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        self.helper(s,0,[])
        return self.res

    def helper(self,s,pivot,path):
        if pivot == len(s):
            self.res.append(copy.deepcopy(path))

        for i in range(pivot,len(s)):
            substr= s[pivot:i+1]
            if self.pallindrome(substr):
                path.append(substr)
                self.helper(s,i+1,path)
                path.pop()


    def pallindrome(self,substr):
        start=0
        end = len(substr)-1

        while(start<end):
            if substr[start]!=substr[end]:
                return False
            
            start+=1
            end-=1

        return True