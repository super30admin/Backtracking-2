#Time Complexity: Exponential
#Space: O(N)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        if s is None or len(s)==0:
            return []
        self.helper(s,0,[])
        return self.result
    def helper(self,s,index,path):
        #base
        if index==len(s):
            self.result.append(copy.copy(path))
            return
        #logic
        for i in range(index,len(s)):
            if self.isPalindrome(s,index,i):
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop()
    def isPalindrome(self,ss,l,r):
        while l<r:
            if ss[l]!=ss[r]:
                return False
            l+=1
            r-=1
        return True
