#Time Complexity: O(n*2^n) where n is the length of the input string s
#Space Complexity: O(n*2^n) where n is the length of the input string s

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        self.helper(s, [])
        return self.result

    def helper(self, s, path):
        if len(s) == 0:
            self.result.append(list(path))
            return  

        for i in range(len(s)):
            subStr = s[:i+1]
            if self.isPalindrome(subStr):
                #action
                path.append(subStr)
                #recurse
                self.helper(s[i+1:], path)
                #backtrack
                path.pop()

    def isPalindrome(self, s):
        left, right = 0, len(s)-1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
        