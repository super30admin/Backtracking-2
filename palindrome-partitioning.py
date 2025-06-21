"""
Time - O(n*2^n)
Space - O(n*2^n)
"""

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def isPalindrome(sub: str) -> bool:
            return sub == sub[::-1]

        def backtrack(s, pivot, path):
            # base
            if pivot == len(s):
                res.append(path[:])
                return

            for i in range(pivot, len(s)):
                currStr = s[pivot:i+1]
                if isPalindrome(currStr):
                    # action
                    path.append(currStr)
                    # recurse
                    backtrack(s, i+1, path)
                    # backtrack
                    path.pop()

        backtrack(s, 0, [])
        return res

        