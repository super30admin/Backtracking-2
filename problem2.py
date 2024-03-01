# Time Complexity : O(N x 2^N) where N is the length of the string
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only

# Approach : At every position of the string we have two chances, whether to consider it in the input or not.
# If we take a substring, we have to check if it is a palindrome or not. If yes we will add it to the result
# and search from end + 1 and look for next substring. If the total count is equal to the input string. we add it to
# the result.

from typing import List


class Solution:
    result = []

    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.substring(s, 0, 0, [], 0)
        return self.result

    def substring(self, s, start, end, cur_result, count):
        if end == len(s):
            if count == len(s):
                t = []
                t.extend(cur_result)
                print(cur_result)
                self.result.append(t)
            return

        # No take
        self.substring(s, start, end + 1, cur_result, count)

        # Take
        cur_str = s[start: end + 1]
        if self.isPalindrome(cur_str):
            cur_result.append(cur_str)
            self.substring(s, end + 1, end + 1, cur_result, count + len(cur_str))
            cur_result.pop()

    def isPalindrome(self, s):
        low, high = 0, len(s) - 1
        while low < high:
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        return True