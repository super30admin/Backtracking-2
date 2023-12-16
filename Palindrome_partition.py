# TC: O(2^N)
# SC: O(N) 

class Solution:
    res=[]

    def helper(self,s,pivot,li):
        if pivot==len(s):
            self.res.append(li.copy())

        for i in range(pivot,len(s)):
            k=s[pivot:i+1]
            if k==k[::-1]:
                print(k)
                li.append(s[pivot:i+1])
                self.helper(s,i+1,li)
                li.pop()

    def partition(self, s: str) -> List[List[str]]:
        self.res=[]
        self.helper(s,0,[])
        return self.res

        