"""
TC: O(N * 2^N) {where N is the length of the string. In the worst case, there are up to `2^(N-1)` partitions, and each palindrome check takes `O(N)` time.}
SC: O(N) {The space complexity is determined by the recursion stack depth, which can go up to `N`, and the path list.}

Approach:

This problem is solved using a **backtracking** algorithm to find all possible palindrome partitions of the input string. The approach is recursive and works by building a valid partition step by step. A helper function `isPal` is used to check if a substring is a palindrome.

The recursive `backtrack` function iterates through the string, starting from a `pivot` index. For each substring starting at the `pivot`, we check if it's a palindrome. If it is, we add it to our current partition `path` and make a recursive call for the remaining part of the string, with the new `pivot` being the index immediately following the current substring. After the recursive call returns, we **backtrack** by removing the last added substring from our `path`, allowing us to explore alternative partitions. The base case for the recursion is when the `pivot` reaches the end of the string, signifying a complete and valid partitioning.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPal(char):
            l,r = 0, len(char)-1
            while l<r:
                if char[l] != char[r]:
                    return False
                l+=1
                r-=1
            return True

        def backtrack(pivot, path):
            #base case
            if pivot >= len(s):
                res.append(path[:])
                return

            #logic
            for i in range(pivot, len(s)):
                curr = s[pivot:i+1]
                if isPal(curr):
                    path.append(curr)
                    backtrack(i+1, path)
                    path.pop()

        res = []
        backtrack(pivot = 0, path = [])
        return res