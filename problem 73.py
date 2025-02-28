# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

# Time Complexity : O(n * 2^n)
# Space Complexity : O(n * 2^n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s == None or len(s) == 0:
            return []
        self.res = []
        self.helper(s,0,[])
        return self.res
    
    def helper(self,s,pivot,path):
        # base
        if(pivot == len(s)):
            self.res.append(path.copy())
            return 

        # logic
        for i in range(pivot,len(s)):
            currpart = s[pivot:i+1]
            if (self.palindrome(currpart,0,len(currpart)-1)):
                path.append(currpart)
                self.helper(s,i+1,path)
                path.pop()


    def palindrome(self,s,l,r):
        while l<r:
            if(s[l] != s[r]):
                return False
            l+=1
            r-=1

        return True

        