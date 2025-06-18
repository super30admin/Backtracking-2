# Time Complexity : O(N*2^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def is_palindrome(sub):
            return sub == sub[::-1]
        def backtrack(start, path):
            if start == len(s):
                res.append(path[:])
                return
            for end in range(start + 1, len(s) + 1):
                if is_palindrome(s[start:end]):
                    backtrack(end, path + [s[start:end]])
        backtrack(0, [])
        return res
        