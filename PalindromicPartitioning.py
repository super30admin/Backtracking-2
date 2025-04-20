# Time Complexity: O(2^n *n)
# Space Complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any problems while coding this: No

from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.helper(s,0,[],result)
        return result

    def helper(self, s, pivot, path, result):
        if pivot == len(s):
            result.append(path[:])
        for i in range(pivot, len(s)):
            subStr = s[pivot:i+1]
            if self.isPalindrome(subStr):
                # action
                path.append(subStr)
                # recurse
                self.helper(s, i+1, path, result)
                # backtrack
                path.pop()


    def isPalindrome(self, s):
        left = 0
        right = len(s)-1
        while(left < right):
            if s[left]!= s[right]:
                return False
            left += 1
            right -= 1
        return True