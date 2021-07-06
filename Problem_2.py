class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if s == None or len(s) == 0:
            return self.result
        self.helper(s, [])
        return self.result
    
    def helper(self, s: str, path: List[str]) -> None:
        # base
        if len(s) == 0:
            self.result.append(path.copy())
            return
        
        for i in range(0,len(s)):
            if self.isPalindrome(s, 0, i):
                path.append(s[0:i+1])
                self.helper(s[i+1:], path)
                path.pop()

# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.result = []
#         if s == None or len(s) == 0:
#             return self.result
#         self.helper(s, 0, [])
#         return self.result
    
#     def helper(self, s: str, index: int, path: List[str]) -> None:
#         # base
#         if index == len(s):
#             self.result.append(path.copy())
#             return
        
#         for i in range(index,len(s)):
#             if self.isPalindrome(s, index, i):
#                 path.append(s[index:i+1])
#                 self.helper(s, i+1, path)
#                 path.pop()
                
    
    def isPalindrome(self, s: str, l: int, r: int) -> bool:
        if l == r:
            return True
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

# Time Complexity: Exponential
        

