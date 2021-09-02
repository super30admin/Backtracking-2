class Solution:
    def __init__(self):
        self.result = []

    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

    """
    Backtracking Approach
    TC - O(n^2)
    SC - O(n)
    """

    def approach1(self, s, path):
        if len(s) == 0:
            self.result.append(path.copy())
            return
        for i in range(len(s)):
            if self.isPalindrome(s, 0, i):
                path.append(s[0:i + 1])
                self.approach1(s[i + 1:], path)
                path.pop()

    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        self.approach1(s, [])
        return self.result