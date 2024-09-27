"""
Approach: generate candidates and check if they are a palindrome. do DFS traversal to generate candidates
TC: O(2^n)
SC: O(n)
"""
from copy import copy
class Solution:
    def __init__(self):
        self.result = []

    def isPalindrome(self, word, start, end):
        while start < end:
            if word[start] != word[end]:
                return False
            start += 1
            end -= 1
        return True

    def partition(self, s: str) -> List[List[str]]:
        self.backtrack(s, 0, [])
        return self.result

    def backtrack(self, s, index, path):
        # base
        if index == len(s):
            self.result.append(deepcopy(path))
            return

            # logic
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                path.append(s[index:i + 1])
                self.backtrack(s, i + 1, path)
                path.pop()