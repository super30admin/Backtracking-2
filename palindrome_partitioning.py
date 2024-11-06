class Solution:
    def __init__(self):
        self.result = []

    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        if pivot == len(s):
            self.result.append(path.copy())
            return

        for i in range(pivot, len(s)):
            sub = s[pivot : i + 1]

            if self.palindrome(sub):
                path.append(sub)
                self.helper(s, i + 1, path)
                path.pop()

    def palindrome(self, s):
        if s == s[::-1]:
            return True
        else:
            return False


# Time Complexity: O(2^n*n^2)
# Space Complexity: O(n * 2^n)
