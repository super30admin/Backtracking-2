# Time Complexity : O(2^n * n), where n is the length of the string
#   - There are up to 2^n possible partitions, and each substring check can take up to O(n)
# Space Complexity : O(n), for the recursion stack and path
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used backtracking to explore all possible partitions of the string.
# At each step, I checked every possible prefix and only continued the recursion if it was a palindrome.
# I added the partition to the result only when I reached the end of the string.

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def is_palindrome(sub: str) -> bool:
            return sub == sub[::-1]

        def backtrack(start: int, path: List[str]):
            if start == len(s):
                result.append(path[:])
                return

            for end in range(start + 1, len(s) + 1):
                substring = s[start:end]
                if is_palindrome(substring):
                    path.append(substring)
                    backtrack(end, path)
                    path.pop()

        backtrack(0, [])
        return result
