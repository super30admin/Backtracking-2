from typing import List


class Solution:

    def __init__(self):
        self.result = []

    def partition(self, s: str) -> List[List[str]]:
        """
            https://leetcode.com/problems/palindrome-partitioning/
            Time complexity - O(n * 2^n)
                'n' is the length of the string.
                2^n is the number of choices for each character in string.
                n is the time taken to check if it is a palindrome
            Space complexity - O(n)
                'n' is the recursive stack space.
        """
        # edge case
        if not s:
            return self.result
        # running list
        self._backtrack(s, 0, [])
        return self.result

    def _backtrack(self, s: str, idx: int, temp: list):
        # base
        if idx == len(s):
            self.result.append(list(temp))
            return
        # logic
        for i in range(idx, len(s)):
            if self._is_palindrome(s, idx, i):
                temp.append(s[idx:i + 1])
                self._backtrack(s, i + 1, temp)
                # backtrack
                temp.pop()

    def _is_palindrome(self, s: str, left: int, right: int):
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True


if __name__ == '__main__':
    h = Solution()
    print(h.partition('aabc'))
