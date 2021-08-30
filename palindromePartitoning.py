"""
//Time Complexity : O(n*2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        #bactrack solution
        self.result = []
        if len(s)==0:
            return self.result
        self.backtrack(s,0,[])
        return self.result
    def backtrack(self,s,index,path):
        #base
        if(len(s)==0):
            self.result.append(list(path))
            return
        #logic
        
        for i in range(0,len(s)):
            if(self.isPalindrome(s,0,i)):
                path.append(s[0:i+1])
                self.backtrack(s[i+1:],i+1,path)
                path.pop()
    def isPalindrome(self,s,l,r):
        while(l<r):
            if(s[l]!=s[r]):
                return False
            l+=1
            r-=1
        return True
        
#         #recursion solution T.C = (n*2^n)
#         self.result = []
#         if len(s)==0:
#             return self.result
#         self.recurse(s,0,[])
#         return self.result
#     def recurse(self,s,index,path):
#         #base
#         if(len(s)==0):
#             self.result.append(path)
#             return
#         #logic
        
#         for i in range(0,len(s)):
#             if(self.isPalindrome(s,0,i)):
#                 copy = list(path)
#                 copy.append(s[0:i+1])
#                 self.recurse(s[i+1:],i+1,copy)
#     def isPalindrome(self,s,l,r):
#         while(l<r):
#             if(s[l]!=s[r]):
#                 return False
#             l+=1
#             r-=1
#         return True
            
        