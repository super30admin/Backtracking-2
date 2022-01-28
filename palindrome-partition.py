# Time Complexity : O(2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes


from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        subs = []

        def isPalindrome(s, i, j):

            while i < j:
                if s[i] != s[j]:
                    return False

                i = i + 1
                j = j - 1
            return True

        def dfs(i):
            if i == len(s):
                result.append(subs.copy())
                return

            for j in range(i, len(s)):

                if isPalindrome(s, i, j):
                    # add current substring in the currentList
                    subs.append(s[i:j+1])
                    dfs(j + 1)

                    # backtrack and remove the current substring from currentList
                    subs.pop()

        dfs(0)
        return result
