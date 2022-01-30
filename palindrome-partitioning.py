'''
TC: O(n*2^n)
SC: O(n)
'''
class Solution:
    def __init__(self):
        self.res = list()
    
    def helper(self, idx, s, elem):
        if idx >= len(s):
            self.res.append(elem[:])
            return
        
        for i in range(idx, len(s)): # O(n)
            curr = s[idx:i+1]
            if curr == curr[::-1]:
                elem.append(curr)
                self.helper(i + 1, s, elem)
                elem.pop()
        
    
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return self.res
        
        self.helper(0, s, [])
        return self.res
        
        