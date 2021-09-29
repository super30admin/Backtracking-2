#Time Complexity : O(2^n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    res = []
    def isplaindrome(self, s, l, r):
        if l==r:
            return True
        while l<r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
    
    def helper(self, s, index, path):
        if index >= len(s):
            path1 = []
            path1.extend(path)
            Solution.res.append(path1)
        
        for i in range(index, len(s)):
            if (self.isplaindrome(s, index, i)):
                path.append(s[index:i+1])
                self.helper(s, i+1, path)
                del path[-1]
                
    def partition(self, s: str) -> List[List[str]]:
        Solution.res = []
        path = []
        self.helper(s, 0, path)
        return Solution.res