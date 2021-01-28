# Time Complexity : O(N^2 * 2^N) exponential n^2 bc palindrome and substring s[index:i+1]
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Originally had problems trying to check if current String 
# is palindrome outside of for loop. And in my isPalindrome I should've passed in parameters of 
# to check the sections of the string


# Your code here along with comments explaining your approach


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        if not s:
            return res
        
        self.helper(s,[], 0, res)
        
        return res
        
    def helper(self, s, temp, index, res):
        if index == len(s):
            res.append(list(temp))
            return
            
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                #action
                temp.append(s[index:i+1])
                #recurse
                self.helper(s, temp, i+1, res)            
                #backtrack
                temp.pop()
            
    def isPalindrome(self, s, start, end):
        # if s == s[::-1]:
        #     return True
        if start == end:
            return True
        
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1 
            end -= 1
        
        return True