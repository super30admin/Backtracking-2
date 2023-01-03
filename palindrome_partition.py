#Time Complexity :  O(n * 2^n)
#Space Complexity :  O(n)
#Did this code successfully run on Leetcode : Yes

#code along with comments 
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        sublist = []
        
        def helper(i):
            if i == len(s):                            #base case
                result.append(sublist.copy())          #if out of bounds we append content in strings to result
                return
            for j in range(i, len(s)):                 #otherwise we iterate from ith index until end
                if self.isPalindrome(s, i, j):
                    sublist.append(s[i:j+1])           #action
                    helper(j+1)                        #recurse
                    sublist.pop()                      #backtrack
                    
        helper(0)
        return result
    
    def isPalindrome(self, s, i, j):                    #function to check palindrome
        while i < j:
            if s[i] != s[j]:
                return False
            i, j = i+1, j-1
        return True