# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    result = None 
    def partition(self, s):
        self.result = []
        if not s or len(s) == 0 :
            return self.result
        self.backtrack(s,0,[])
        return self.result
    
    def backtrack(self,s,indx,temp):
        #base 
        if indx == len(s):
            self.result.append(temp.copy())
            return 
        
        # Logic 
        for i in range(indx,len(s)):
            curr = s[indx:i+1]
            if self.palindrome(s,indx,i):
                temp.append(curr)
                self.backtrack(s,i+1,temp)
                temp.pop()
                
        
    def palindrome(self,s,start,end):
        if not s or len(s) == 0:
            return False 
        
        while start < end:
            if s[start] != s[end]:
                return False 
            start += 1 
            end -= 1 
        return True 

if __name__ == "__main__":
    s = Solution()
    res = s.partition("aab")
    print(res)