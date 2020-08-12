#Backtracking-2
#Problem1 : https://leetcode.com/problems/palindrome-partitioning/
#All test cases passed on Leetcode

#Time Complexity:    O(n*2^n)Exponential
#Space Complexity:    O(n) 
class Solution:
    def __init__(self):
        self.result=[]
    def isPalindrome(self,s,l,r):
        if l==r:
            return True
        while l<r:
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True
    
    def backtrack(self,s,temp,start):
        #base case:
        if start>=len(s):
            self.result.append(list(temp))
            return
        for i in range(start,len(s)):
            if self.isPalindrome(s,start,i):
                #action
                temp.append(s[start:i+1])
                #recurse
                self.backtrack(s,temp,i+1)
                #backtrack
                temp.pop()
    def partition(self, s: str) -> List[List[str]]:
    
        if s==None or len(s)==0:
            return self.result
        self.backtrack(s,[],0)
        return self.result
        
        