# Time Complexity : O(2^n * n) -> For n length string, exponential partitions × (palindrome checks + creating substrings)
# Space Complexity : O(n^2) (substring creation and recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We start at the first index and keep trying all substrings from that point.
# Whenever we find a palindrome substring, we add it and recurse from the next index.
# Once we reach the end, we save the current list, and then backtrack to try other splits.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(s, 0, [])
        return self.res

    def helper(self, s, pivot, path):
        if pivot == len(s):
            self.res.append(list(path))
            return

        for i in range(pivot, len(s)):
            subStr = s[pivot:i+1]
            if self.isPalindrome(subStr):
                path.append(subStr)
                self.helper(s, i+1, path)
                path.pop()

    def isPalindrome(self, s):
        left, right = 0, len(s)-1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
        