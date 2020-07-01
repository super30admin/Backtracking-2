#131. Palindrome Partitioning
# Time Complexity : O(2^n) 
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
#In backtrack sol we will choose the first ele of string and check if its palindrome or not . The recursion happen on all the remaining elements in ths str. and finally pop the elemnet and continue the recursion.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        self.result = []
        self.backtrack(s,[],0)
        return self.result
    def backtrack(self,s,temp,start):
        if start == len(s):
            self.result.append(temp.copy())
            return
        for i in range(start,len(s)):
            if self.palindrome(s,start,i):
                temp.append(s[start:i+1])
                self.backtrack(s,temp,i+1)
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
        
