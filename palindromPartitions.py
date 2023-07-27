class Solution:
    def partition(self, s: str) -> List[List[str]]:

        def isPalindrom(low, high):
            while low <= high:
                if s[low] != s[high]:
                    return False
                low += 1
                high -= 1
            return True

        def helper(curr):
            # base case
            if curr >= len(s):
                self.result.append(self.path.copy())
                return

            # main logic
            for i in range(curr, len(s)):
                if isPalindrom(curr, i):
                    self.path.append(s[curr:i+1])
                    helper(i+1)
                    self.path.pop()

        self.result = []
        self.path = []
        helper(0)
        return self.result
