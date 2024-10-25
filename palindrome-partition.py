"""
The main idea is to find the all possible combinations of the partition, meaning what if there is one partition,
what if there are 2 partitions? what if there are 3 partitions? the max number of partiton would depend on the
lenght of string.

For loop-based recursion: two variables are used, pivot and index, when moving to the next level pivot is moved, since
characters are not repeated.
 substrings are formed from pivot to index.
 The first branch would be the one where partition of length one are created, meaning [a, b, c]
 TC: 2^n * N to check palindrome
 SC: O(n) # height of tree
 TOdo: solve 0-1 recursion
"""
from typing import List


class Solution:
    def chek_palindrome(self, word):
        i, j = 0, len(word) - 1

        while (i <= j):
            if word[i] != word[j]:
                return False
            i += 1
            j -= 1
        return True

    def helper(self, s, pivot, path):

        if pivot >= len(s):
            print(path)
            self.ans.append(path[:])

        for i in range(pivot, len(s)):
            word = s[pivot:i + 1]
            ispalindrome = self.chek_palindrome(word)

            if ispalindrome:
                path.append(word)
                self.helper(s, i + 1, path)
                path.pop()

    def partition(self, s: str) -> List[List[str]]:
        self.ans = []
        self.helper(s, 0, [])
        return self.ans


