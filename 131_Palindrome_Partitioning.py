# Time Complexity : O(2^n * n)[n = length of input string]
# Space Complexity : O(n) [n = length of input string]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Start with an empty list and iterate over the string.
# 2. Explore the recursive path only if the substring formed with current index is a palindrome
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def isPalindrome(s): # O(n)
            start = 0
            end = len(s)-1
            while start < end:
                if s[start] != s[end]:
                    return False
                start+=1
                end-=1
            return True
        def backtrack(s, start, curr):
            nonlocal res
            ## base
            if start == len(s):
                res.append([num for num in curr])
                return
            
            ## body
            
            for i in range(start, len(s)):
                if isPalindrome(s[start:i+1]):
                    # action
                    curr.append(s[start:i+1])
                    # recurse
                    backtrack(s, i+1, curr)
                    # backtrack
                    curr.pop()
        backtrack(s, 0 , [])
        return res