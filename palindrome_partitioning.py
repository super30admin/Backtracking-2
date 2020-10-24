"""
Problem: 131. Palindrome Partitioning
Leetcode: https://leetcode.com/problems/palindrome-partitioning/
Solution: Backtracking
Time Complexity : O(N*2^N), where N is the length of string s.
    - This is the worst-case time complexity when all the possible substrings are palindrome.
Space Complexity: O(N), where N is the length of the string s. This space will be used to store the recursion stack.
Does this code run on Leetcode: Yes
"""


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        output = []
        path = []

        self.backtracking(output, s, 0, path)
        return output

    def backtracking(self, output, s, index, path):
        # base case || right output
        if index >= len(s):
            output.append(deepcopy(path))
            return

        # recursive case
        for i in range(index, len(s)):
            temp = s[index:i + 1]
            if self.isPalindrome(temp):
                path.append(temp)
                self.backtracking(output, s, i + 1, path)
                path.pop()

    def isPalindrome(self, string):
        left = 0
        right = len(string) - 1

        while left < right:
            if string[left] != string[right]:
                return False
            left += 1
            right -= 1
        return True
