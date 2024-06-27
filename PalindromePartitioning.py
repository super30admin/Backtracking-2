# Time Complexity : O(2^n * n)
# Space Complexity : O(2^n * n)
class Solution:
    def __init__(self):
        self.result = []

    def partition(self, s: str) -> list:
        if not s:
            return []
        self.result = []
        self.backtrack(s, 0, [])
        return self.result

    def backtrack(self, s: str, index: int, path: list):
        if index == len(s):
            self.result.append(list(path))
            return
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                path.append(s[index:i + 1])
                self.backtrack(s, i + 1, path)
                path.pop()

    def isPalindrome(self, s: str, l: int, r: int) -> bool:
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

# Example usage:
sol = Solution()

# Example 1
s1 = "aab"
print(sol.partition(s1))

# Example 2
s2 = "aaba"
print(sol.partition(s2))

# Example 3
s3 = "efe"
print(sol.partition(s3))