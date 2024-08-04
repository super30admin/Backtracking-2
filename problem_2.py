# Time O(2**N)
# Space O(N)
class Solution:
    def __init__(self):
        self.result = []
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        self.backtrack(s, 0, [])
        return self.result
    def backtrack(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(list(path))
            return 

        # logic 
        for i in range(index, len(s)):
            if self.is_pal(s, index, i): 
                #action
                path.append(s[index:i+1])
                # recurse
                self.backtrack(s, i+1, path)
                #remove 
                path.pop()


    
    
    def is_pal(self,s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False 
            l += 1
            r -= 1
        return True
        