class Solution:
    def partition(self, s: str) -> List[List[int]]:
        self.s = s
        self.res = list()
        self.helper(0, [])
        return self.res

    def helper(self, pivot, path):
        # Base
        if pivot == len(self.s):
            if self.isPalindrome(path):
                self.res.append(path.copy())
            return
        # Logic
        # Action
        for i in range(pivot, len(self.s)):
            path.append(self.s[pivot: i+1])
        # Recurse
            self.helper(i+1, path)
        # Backtrack
            path.pop()

    def isPalindrome(self, path):
        for i in path:
            start = 0
            last = len(i) - 1
            while (start < last):
                if i[start] == i[last]:
                    start += 1
                    last -= 1
                else:
                    return False
        return True
# class Solution:
#     """
#     Time Complexity: O(n * 2^n)
#     Space Complexity: O(n)
#     Approach:
#         - backtracking is applicable over here
#         - For-loop based recursion is applied over here where 
#         the loop starts from pivot until the end of the string
#         - A check is applied to see if a string(from pivot to i) is a palindrome or not 
#             - if yes then we append the string(from pivot to i) to the path and pass the path 
#             to the recursive function and change the pivot to i+1
#             - we do it until the end of the string and append the copy of path to the result
#         - In the end result is returned
#     """
#     def partition(self, s: str) -> List[List[str]]:
#         self.result = list()
#         self.helper(s, 0, [])
#         return self.result
    
#     def helper(self, st, pivot, path):
#         # Base
#         if pivot == len(st):
#             # IsPalindrome or not
#             self.result.append(path.copy())
#             return

#         # Logic
#         for i in range(pivot, len(st)):
#             # Action            
#             if self.is_palindrome(st[pivot: i+1]):
#                 path.append(st[pivot: i+1])
#                 # Recurse
#                 self.helper(st, i+1, path)
#                 # Backtrack
#                 path.pop()

#     def is_palindrome(self, palindrome):
#         i = 0 
#         j = len(palindrome) - 1
#         while (i < j):
#             if not palindrome[i] == palindrome[j]:
#                 return False
#             i += 1
#             j -= 1
#         return True