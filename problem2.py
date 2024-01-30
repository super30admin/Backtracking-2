#Time Complexity : O(N * 2^N), where N is the length of the input string s
#Space Complexity :O(N * 2^N)
#Did this code successfully run on Leetcode : yes

from ast import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        path = []
        self.helper_fun(0, s, path, result)
        return result
    
    def helper_fun(self, idx, s, path, result):
        if idx >= len(s):
            result.append(path[:])  
            return
        
        for i in range(idx, len(s)):
            if self.isPalindrome(s, idx, i):
                path.append(s[idx:i+1])
                self.helper_fun(i+1, s, path, result)
                path.pop()  
    
    def isPalindrome(self, s, start, end):
        while start <= end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True