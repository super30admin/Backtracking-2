#Time complexity: O(n*2^n)
#Space complexity: O(n)
class Solution:
    def __init__(self):
        self.res = []
    def pal(self, s):
        return s == s[::-1]
    def partition(self, s: str) -> List[List[str]]:
        self.helper(s, 0, [])
        return self.res
    def helper(self, s, idx, path):
        if idx == len(s):
            self.res.append(path.copy())
        
        for i in range(idx, len(s)):
            sb = s[idx:i+1]
            if self.pal(sb):
                path.append(sb)
                self.helper(s, i+1, path)
                del path[-1]
        
        
