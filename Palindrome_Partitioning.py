class Solution:
    """For loop, recursion, backtracking
    Time complexity-O(n*(2^n))
    Space Complexity-O(2^n)"""
    def __init__(self):
        self.result=[]
    def partition(self, s: str) -> List[List[str]]:
        path=[]
        self.helper(s,0,path)
        return self.result
    
    def helper(self, s,index, path):
        if len(s)==index:
            self.result.append(path[:])
            return
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                path.append(s[index:i+1])
                self.helper(s,i+1, path)
                path.pop()
                
    def isPalindrome(self, s, l,r):
        while l<r:
            if s[l]!=s[r]:
                return False
            l+=1
            r-=1
        return True
    """BackTracking"""
#     def __init__(self):
#         self.result=[]
#     def partition(self, s: str) -> List[List[str]]:
#         path=[]
#         self.helper(s,path)
#         return self.result
    
#     def helper(self, s,path):
#         if len(s)==0:
#             self.result.append(path[:])
#             return
#         for i in range(len(s)):
#             if self.isPalindrome(s, 0, i):
#                 path.append(s[:i+1])
#                 self.helper(s[i+1:], path)
#                 path.pop()
                
#     def isPalindrome(self, s, l,r):
#         while l<r:
#             if s[l]!=s[r]:
#                 return False
#             l+=1
#             r-=1
#         return True
    """Recursion"""
#     def __init__(self):
#         self.result=[]
#     def partition(self, s: str) -> List[List[str]]:
#         path=[]
#         self.helper(s,path)
#         return self.result
    
#     def helper(self, s,path):
#         if len(s)==0:
#             self.result.append(path)
#             return
#         for i in range(len(s)):
#             if self.isPalindrome(s, 0, i):
#                 pathcopy=path[:]
#                 pathcopy.append(s[:i+1])
#                 self.helper(s[i+1:], pathcopy)
                
#     def isPalindrome(self, s, l,r):
#         while l<r:
#             if s[l]!=s[r]:
#                 return False
#             l+=1
#             r-=1
#         return True
        
        