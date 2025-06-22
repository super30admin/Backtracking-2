from typing import List
# time o(n*2^n) space = o(length of the string or path)
# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.res = []
#         def isPalindrome(s,l,r):
#             while l<r:
#                 if s[l] != s[r]:
#                     return False
#                 l+=1
#                 r-=1
#             return True
#         def helper(s, pivot, path):
#             #base
#             if pivot == len(s):
#                 self.res.append(path[:])
#                 return

#             #logic 
#             for i in range(pivot, len(s)):
#                 currStr = s[pivot:i+1]
#                 if isPalindrome(currStr,0,len(currStr)-1):
#                     #action
#                     path.append(currStr)
#                     #recurse
#                     helper(s, i+1, path)
#                     #backtrack
#                     path.pop()

#         helper(s, 0 , [])
#         return self.res

# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.res = []
#         def isPalindrome(s,l,r):
#             while l<r:
#                 if s[l] != s[r]:
#                     return False
#                 l+=1
#                 r-=1
#             return True
#         def helper(s, path):
#             #base
#             if len(s) == 0:
#                 self.res.append(path[:])
#                 return

#             #logic 
#             for i in range(0, len(s)):
#                 currStr = s[0:i+1]
#                 if isPalindrome(currStr,0,len(currStr)-1):
#                     #action
#                     path.append(currStr)
#                     #recurse
#                     helper(s[i+1:], path)
#                     #backtrack
#                     path.pop()

#         helper(s, [])
#         return self.res

# Non backtracking
# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.res = []
#         def isPalindrome(s,l,r):
#             while l<r:
#                 if s[l] != s[r]:
#                     return False
#                 l+=1
#                 r-=1
#             return True
#         def helper(s, pivot, path):
#             #base
#             if pivot == len(s):
#                 self.res.append(path[:])
#                 return

#             #logic 
#             for i in range(pivot, len(s)):
#                 currStr = s[pivot:i+1]
#                 if isPalindrome(currStr,0,len(currStr)-1):
#                     li = path[:]
#                     li.append(currStr)
#                     #recurse
#                     helper(s, i+1, li)

#         helper(s, 0 , [])
#         return self.res

# class Solution:
#     def partition(self, s: str) -> List[List[str]]:
#         self.res = []
#         def isPalindrome(s,l,r):
#             while l<r:
#                 if s[l] != s[r]:
#                     return False
#                 l+=1
#                 r-=1
#             return True
#         def helper(s, pivot, path):
#             #base
#             if pivot == len(s):
#                 self.res.append(path)
#                 return

#             #logic 
#             for i in range(pivot, len(s)):
#                 currStr = s[pivot:i+1]
#                 if isPalindrome(currStr,0,len(currStr)-1):
#                     li = path[:]
#                     li.append(currStr)
#                     #recurse
#                     helper(s, i+1, li)

#         helper(s, 0 , [])
#         return self.res


from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []

        def isPalindrome(s, l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        def helper(pivot, idx, path, count):
            # Base case: when idx has reached the end
            if idx == len(s):
                if count == len(s):  # only add path if full string is partitioned
                    self.res.append(path[:])
                return

            # 0 case: don't choose current substring, move forward
            helper(pivot, idx + 1, path, count)

            # 1 case: choose the current substring if it's a palindrome
            currStr = s[pivot:idx + 1]
            if isPalindrome(currStr, 0, len(currStr) - 1):
                path.append(currStr)
                new_count = count + len(currStr)
                helper(idx + 1, idx + 1, path, new_count)
                path.pop()

        helper(0, 0, [], 0)
        return self.res


        
        

        