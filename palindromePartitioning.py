# For loop BT
# Time Complexity - O(n * 2^n)
# Space Complexity - O(n)

class Solution:
    def __init__(self):
        self.rtnData = []

    def partition(self, s: str) -> List[List[str]]:
        if s is None or len(s) == 0: return self.rtnData

        self.helper(s, 0, [])

        return self.rtnData

    def helper(self, s, index, path):
        # base
        if index == len(s):
            self.rtnData.append(path.copy())
            return

        # logic
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                # action
                path.append(s[index:i + 1])
                # recurse
                # i+1 because the for loop is between index to i. so we increment i
                self.helper(s, i + 1, path)
                # backtrack
                path.pop()

    def isPalindrome(self, s, left, right):
        while left <= right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
