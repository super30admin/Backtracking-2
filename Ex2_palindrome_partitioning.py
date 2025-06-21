from functools import lru_cache

# Time Complexity : O(2^n * n)
# - There are O(2^n) possible partitions (each character can be a cut or not)
# - For each partition, we spend up to O(n) checking palindromes and copying lists
#
# Space Complexity : O(n) recursion stack + O(2^n * n) output
# - O(n) for call stack depth
# - O(2^n * n) to store final result

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:

        @lru_cache(None)
        def is_palindrome(l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        # ------------------------------------------------------
        # 1. For-loop Based Backtracking 
        res = []
        part = []

        def dfs(pivot):
            if pivot == len(s):
                res.append(part[:])
                return
            for i in range(pivot, len(s)):
                if is_palindrome(pivot, i):
                    part.append(s[pivot:i+1])  # action
                    dfs(i + 1)                 # recurse
                    part.pop()                # backtrack

        dfs(0)
        return res

        # ------------------------------------------------------
        # 2. For-loop Based Recursion (no backtracking)
        # Time: O(2^n * n)
        # Space: O(2^n * n) for output + O(n) for call stack (new list each level)
        #
        # res = []
        #
        # def is_palindrome(l, r):
        #     while l < r:
        #         if s[l] != s[r]:
        #             return False
        #         l += 1
        #         r -= 1
        #     return True
        #
        # def dfs(pivot, path):
        #     if pivot == len(s):
        #         res.append(path[:])
        #         return
        #     for i in range(pivot, len(s)):
        #         if is_palindrome(pivot, i):
        #             new_path = path + [s[pivot:i+1]]  # no mutation
        #             dfs(i + 1, new_path)
        # dfs(0, [])
        # return res

        # ---------------------------------------------------------
        # 3. 0-1 Recursion Backtracking
        # Time: O(2^n * n)
        # Space: O(n) recursion + O(2^n * n) output
        #
        # res = []
        # part = []

        # def is_palindrome(l, r):
        #     while l < r:
        #         if s[l] != s[r]:
        #             return False
        #         l += 1
        #         r -= 1
        #     return True

        # def dfs(i, j):
        #     if j == len(s):
        #         if i == j:
        #             res.append(part[:])
        #         return
        #     if is_palindrome(i, j):
        #         part.append(s[i:j+1])
        #         dfs(j + 1, j + 1)
        #         part.pop()
        #     dfs(i, j + 1)
        # dfs(0, 0)
        # return res

        # -------------------------------------------------------------
        # 4. 0-1 Recursion without Backtracking
        # Time: O(2^n * n)
        # Space: O(2^n * n) output + O(n) recursion
        #
        # res = []

        # def is_palindrome(l, r):
        #     while l < r:
        #         if s[l] != s[r]:
        #             return False
        #         l += 1
        #         r -= 1
        #     return True

        # def dfs(i, j, path):
        #     if j == len(s):
        #         if i == j:
        #             res.append(path[:])
        #         return
        #     if is_palindrome(i, j):
        #         new_path = path + [s[i:j+1]]
        #         dfs(j + 1, j + 1, new_path)
        #     dfs(i, j + 1, path)
        # dfs(0, 0, [])
        # return res


# Example usage:
if __name__ == "__main__":
    sol = Solution()
    print(sol.partition("aab"))      # [["a","a","b"], ["aa","b"]]
    print(sol.partition("a"))        # [["a"]]
    print(sol.partition("aaba"))     # [["a", "a", "b", "a"], ["a", "aba"], ["aa", "b", "a"]]
    print(sol.partition("racecar"))  # [["r","a","c","e","c","a","r"], ..., ["racecar"]]
    print(sol.partition("abba"))     # [["a", "b", "b", "a"], ["a", "bb", "a"], ["abba"]]
