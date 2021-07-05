# Time Complexity : O(n*2**n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        self.backtracking(s,0,[])
        return self.result

    def backtracking(self,s,ind,strs):
        if ind == len(s):
            self.result.append(strs.copy())
            return

        for i in range(ind+1,len(s)+1):
            if self.isPalindrome(s[ind:i]):
                strs.append(s[ind:i])
                self.backtracking(s,i,strs)
                strs.pop()


    def isPalindrome(self,s):
        if s == s[::-1]:
            return True
        return False 