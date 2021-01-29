# TC: O(n 2**n) exponential
# SC: O(n)
# Pivot pattern backtrack
class Solution:
    def __init__(self):
        self.result = []
        
    def partition(self, s: str):
        if s == None or len(s) == 0: return self.result
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(path.copy())
            return
        # logic
        for i in range(index, len(s)):
            # each time we check if string formed by pivot and i is palin, then we proceed with that sequence
            if self.isPalin(s[index: i+1]):
                # action
                path.append(s[index: i+1])
                # recurse
                self.helper(s, i+1, path)
                # backtrack:
                path.pop()
    # Palin check using 2 pointers
    def isPalin(self, s):
        left, right = 0, len(s) - 1
        while left <= right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True