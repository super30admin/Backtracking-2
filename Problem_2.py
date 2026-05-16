class Solution:
    def partition(self, s):
        result = []
        self.helper(0, s, [], result)
        return result

    def helper(self, pivot, s, path, result):
        if pivot == len(s):
            result.append(list(path))

        for i in range(pivot, len(s)):
            if self.isPalindrome(s, pivot, i):
                path.append(s[pivot : i + 1])
                self.helper(i + 1, s, path, result)
                path.pop()

    def isPalindrome(self, s, i, j):
        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
