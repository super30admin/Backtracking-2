# Time Complexity : O(n*2^n) where n is the length of the string
# Space Complexity : O(n) for the recursion
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Uses recursion to generate all the partitions
# We either proceed the recursion or not, based on the palindrome check of the accumlated substring
# and record all final partitions at the end.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def isPal(s, start, end):
            while start <= end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
        
        def partition(s, start, path):
            if start == len(s):
                res.append(path[:])
                return
            for end in range(start, len(s)):
                if isPal(s, start, end):
                    path.append(s[start:end+1])
                    partition(s, end+1, path)
                    path.pop()

        partition(s, 0, [])
        return res