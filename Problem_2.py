"""
Problem : 2

Time Complexity : O(n*2^n)
Space Complexity : O(2^n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Taking a pivot at the first index of input string, there are multiple options
either taking the first character as a seperate string or the first two characters together,
or the first n characters together,
so iterating the pivot over the entire string, and performing the recursion on the remaining substring
as the pivot reaches the end of the input string, appending the path to result

"""

# Palindrome Partitioning

class Solution(object):
    def __init__(self):
        self.result=[]
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        
        self.helper(0,s,[])

        return self.result
    
    def helper(self,pivot,s,path):
        # base
        if pivot==len(s):
            self.result.append(path[::])
            return

        # logic
        
        for i in range(pivot,len(s)):
            sub=s[pivot:i+1]
            if self.isPalindrome(sub):
                path.append(sub)
                self.helper(i+1,s,path)
                path.pop()
            



    def isPalindrome(self,s):
        start=0
        end=len(s)-1

        while start<end:
            if s[start]!=s[end]:
                return False
            start+=1
            end-=1
        return True