class Solution:
    result = None
    temp = None

    def partition(self, s: str):
        Solution.result = []
        Solution.temp = []
        # edge case
        if len(s) == 0: return Solution.result
        self.backtrack(s, 0)
        return Solution.result

    def backtrack(self, s, start):
        # Base case
        if len(Solution.temp) > 0 and start >= len(s):
            Solution.result.append(Solution.temp[:])
        # Logic
        for i in range(start, len(s)):
            if self.isPalindrome(s, start, i):
                if start == i:
                    Solution.temp.append(s[i])
                else:
                    Solution.temp.append(s[start:i + 1])
                self.backtrack(s, i + 1)
                Solution.temp.pop(-1)

    def isPalindrome(self, s, l, r):
        if l == r: return True
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

