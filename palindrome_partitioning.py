# -*- coding: utf-8 -*-
"""
TC: exponential as every stage we check either choose the substring to be a palindrome or not,i.e. two choices made
SC: O(1) as no extra space, temporary path added to resultant path 
"""

class Solution:
    def partition(self, s: str):
        result, path = [], []
        self.backtracking(s, result, path)
        return result

    def backtracking(self, s, result, path):
        # base case
        if s == '':
            result.append(list(path))
            return
        
        #logic
        #traverse through the string list s
        #check for pailindrome
        #if yes, add it to path list
        #call function recursively
        
        for i in range(len(s)):
            sub_str = s[:i + 1]
            if sub_str == sub_str[::-1]:
                self.backtracking(s[i + 1:], result, path + [sub_str])
                
S = Solution()
print(S.partition("aab"))