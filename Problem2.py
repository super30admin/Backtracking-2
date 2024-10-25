# Time Complexity = O(2^n) | Space Complexity = O(n)

class Solution:
    def partition(self, s: str) -> list[list[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def is_palindrome(self, s: str):
        l = 0
        r = len(s) - 1
        while (l < r):
            if s[l] != s[r]:
                return False
            l += 1;
            r -= 1
        return True

    def helper(self, s: str, pivot: int, path: list[int]):
        # base case
        if pivot == len(s):
            self.result.append(list(path))

        # logic
        for i in range(pivot, len(s)):
            sub = s[pivot:i + 1]
            if self.is_palindrome(sub):
                path.append(sub)
                self.helper(s, i + 1, path)
                del path[-1]
