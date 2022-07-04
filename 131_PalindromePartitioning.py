"""
Leetcode- https://leetcode.com/problems/palindrome-partitioning/ (submitted)
TC-O(2^N * N (palindrome check)) where N is length of string , O(1) SC
Challenges-recursion logic
Lecture-https://www.youtube.com/watch?v=ciYRVgANgbM
FAQ-
Other approaches? We can do recursive without backtracking.


Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.


Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]


Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
"""


class Solution:
    """
    *most optimized*
    Ideation-for loop recursion O(2^N * N (palindrome check)) where N is length of string TC, O(1) SC

    At every index, you have a choice to make a partition there or not. Let's call that pivot
    If you make a partition, if that partition is palindrome, add it to path and move to further partition remaining
    string. If it's not palindrome, stop the recursion there and return to parent (prune that branch)
    If you don't choose to partition, increment 'i' and take the substring pivot to 'i' as your next partition.
    """

    def partition(self, s: str):
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        # base
        if pivot == len(s):
            self.result.append(path[:])
            return
        for i in range(pivot, len(s)):
            # choose partition
            subS = s[pivot: i + 1]
            if self.isPalindrome(subS):
                # action
                path.append(subS)
                self.helper(s, i + 1, path)
                # backtrack
                path.pop()

    # check for palindrome O(N)
    def isPalindrome(self, s):
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1

        return True
