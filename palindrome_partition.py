# Time Complexity :O(N*2^N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



class Solution:
    def is_palindrome(self,s):
        l=0
        h=len(s)-1
        while(l<=h):
            if(s[l]==s[h]):
                
                l+=1
                h-=1
            else:
                return False
        return True

    def helper(self, s, pivot):
        # base
        if(pivot==len(s)):
            self.result.append(self.path[:])
            return 
        # logic
        for i in range(pivot, len(s)):
            temp=""+s[pivot:i+1]
            if(self.is_palindrome(temp)):
                self.path.append(temp)
                self.helper(s, i+1)
                self.path.pop()
        
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        self.path=[]

        self.helper(s, 0)
        return self.result