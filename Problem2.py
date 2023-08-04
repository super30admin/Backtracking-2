#Time Complexity :O(2^n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        self.helper(s,0,[])
        return self.result

    def helper(self,s,pivot,path):
        if pivot==len(s):
            self.result.append(list(path))
            return
        
        for i in range(pivot,len(s)):
            subStr=s[pivot:i+1]
            if self.isPalindrome(subStr):
                path.append(subStr)
                self.helper(s,i+1,path)
                del(path[-1]) 


    def isPalindrome(self,s):
        start=0
        end=len(s)-1
        while(start<end):
            if s[start]!=s[end]:
                return False
            start+=1
            end-=1
        return True

