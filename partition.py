# Time Complexity : O(2^n), due to exploring all possible partitions
# Space Complexity : O(n), for recursion depth and temporary path storage
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# I used backtracking to explore all substring partitions and checked each for palindrome validity

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def is_palindrome(sub):
            return sub == sub[::-1]

        def backtrack(start, path):
            if start == len(s):
                result.append(path[:])
                return
            for end in range(start + 1, len(s) + 1):
                if is_palindrome(s[start:end]):
                    path.append(s[start:end])
                    backtrack(end, path)
                    path.pop()

        backtrack(0, [])
        return result
