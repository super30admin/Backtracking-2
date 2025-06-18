"""
Problem: Palindrome partitioning
Approach: partition at every possible index and do it recursively. and check if start to curr index is a
Palindrome to continue or not.
t.c. => O(n * 2^n) where n is the length of string. take O(n) for string operations for each 2^n leaves
s.c. => O(n)
"""
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        path = []
        res = []
        n = len(s)
        def isPalindrome(l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        def helper(start):
            if start >= n:
                res.append(path.copy())
                return 

            for i in range(start, n):
                if not isPalindrome(start, i):
                    continue

                path.append(s[start : i + 1])
                helper(i + 1)
                path.pop()
        helper(0)
        return res
