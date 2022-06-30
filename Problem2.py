'''
Time Complexity: O(n * 2^n)
Space Complexity: O(n * 2^n)
Run on Leetcode: YES
'''
class Solution:
    def ispal(self, s: str) -> bool:
        start = 0
        end = len(s) - 1
        while(start < end):
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
        
    def helper(self,s: str, result: list[list[str]], path: list[str]):
        #base
        if len(s) == 0:
            result.append(path[:])
            return
        
        #logic
        for i in range(len(s)):
            sub = s[:i+1]
            if self.ispal(sub):
                #action
                path.append(sub)
                #recurse
                self.helper(s[i+1:], result, path)
                #backtrack
                path.pop()
            
        
    def partition(self, s: str) -> list[list[str]]:
        result = []
        if len(s) == 0:
            return [[]]
        self.helper(s, result, [])
        return result