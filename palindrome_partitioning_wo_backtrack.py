# Time Complexity : O(N * 2^N) where is N is length of the string
# Space Complexity : O(N*N) where is N is length of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        self.strPalindromeValidator(s, [], 0)
        return self.result
        
    def strPalindromeValidator(self, s, path, pivot):
        #base
        if pivot == len(s):
            self.result.append(path)
            return
        #logic
        for i in range(pivot, len(s)):
            substr = s[pivot: i+1]
            if self.isPanlindrome(substr):
                temp = path[:]
                temp.append(substr)
                #recurse
                self.strPalindromeValidator(s, temp, i+1)
            
    def isPanlindrome(self, sub):
        i = 0
        j = len(sub) - 1
        
        while i <= j:
            if sub[i] != sub[j]:
                return False
            i += 1
            j -= 1
            
        return True