# TC - O(2^N)
# Sc - O(N)
class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        if len(s) == 0:
            return []
        self.recurse(s,0,[])
        return self.result

    def recurse(self, s, index, path):
        ## base case
        if index == len(s):
            self.result.append(list(path))
            return

        ## logic
        for i in range(index,len(s)):
            if self.isPalindrome(s,index,i):
                path.append(s[index:i+1])
                self.recurse(s,i+1,path)
                path.pop()


    def isPalindrome(self,s,l,r):
        while l<r:
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True                        



    

  
