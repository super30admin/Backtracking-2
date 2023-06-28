# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the subset of string and append it to result if its a palindrome.

class Solution:
    def IsPalindrome(self, s: str):
        start=0
        end=len(s)-1
        while(start<end):
            if( s[start]!=s[end]):
                return False
            start+=1
            end-=1
        return True

    def partition(self, s: str) -> List[List[str]]:
        result=[]
        self.helper(s, 0, [],result)
        return result
    
    def helper(self, s, id, path,res):
        if(id == len(s)):
            li=list(path)
            res.append(li)
            return 

        for i in range(id, len(s)):
            s1=s[id: i+1]
            if(self.IsPalindrome(s1)):
                #action
                path.append(s1)
            
                #recurse
                self.helper(s, i+1, path,res)
            
                #backtrack
                path.pop()