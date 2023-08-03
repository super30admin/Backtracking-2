class Solution:
    # Time Complexity:2^n
    # Space Complexity:2^n
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, path=[])
        return self.result

    def helper(self, s, pivot, path):
        if pivot == len(s):
            self.result.append(list(path))
        for i in range(pivot, len(s)):
            sub = s[pivot : i + 1]
            if self.isPalindrome(sub):
                path.append(sub)
                self.helper(s, i + 1, path)
                path.pop()

    def isPalindrome(self, s):
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
