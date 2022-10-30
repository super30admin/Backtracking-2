##Time Complexity : O(n*2^n)
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result = []
        current = []
        self.recurPartition(result, current, s, 0)
        return result

    def recurPartition(self, result, current, s, start):
        if start == len(s):
            result.append(list(current))
        for i in range(start, len(s)):
            if self.isPalindrome(s, start, i):
                current.append(s[start:i + 1])
                self.recurPartition(result, current, s, i + 1)
                current.pop()

    def isPalindrome(self, s, begin, end):
        while begin < end:
            if s[begin] != s[end]:
                return False
            begin += 1
            end -= 1
        return True
        
        