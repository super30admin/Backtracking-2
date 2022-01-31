# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this

class Solution:
    result = list()
    def partition(self, s: str) -> List[List[str]]:
        self.result =[]
        if s == None or len(s)==0:
            return self.result
        self.helper(s, 0, list())
        return self.result
        
        
    def helper(self,s:str, index:int,path:list):
        # base
        if index == len(s):
            self.result.append(path+list())
        # logic
        for i in range(index,len(s)):
            sub = s[index:i+1]
            if self.isPalindrome(sub):
                #action
                path.append(sub) 
                #recurse
                self.helper(s,i+1,path) 
                # backtrack
                path.pop()
                
        
        
    def isPalindrome(self,s:str)-> bool:
        return s == s[len(s)::-1]
        