# Time Complexity: O(2^n)
# Space Complexity: O(n)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.backtrack(s, 0, [])
        return self.result

    def backtrack(self, s, index, path):
        if index == len(s):
            self.result.append(list(path))
            return

        for i in range(index, len(s)):
            subStr = s[index:i + 1]
            if self.isPalindrome(subStr):
                path.append(subStr)
                self.backtrack(s, i + 1, path)
                path.pop()

    def isPalindrome(self, subStr):
        left = 0
        right = len(subStr) - 1
        while left < right:
            if subStr[left] != subStr[right]:
                return False

            left += 1
            right -= 1
        return True

