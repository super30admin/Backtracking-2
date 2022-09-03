'''
Time Complexity - O(2^n)
Space Complexity - O(n)
'''


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        if pivot == len(s):
            self.result.append(list(path))
            return

        for i in range(pivot, len(s)):
            sub = s[pivot:i+1]
            if self.ispal(sub):
                path.append(sub)
                self.helper(s, i+1, path)
                path.pop()

    def ispal(self, s):
        return s == s[::-1]
