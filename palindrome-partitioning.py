class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = []
        part = []
        def checkPalindrome(s):
            return s == s[::-1]
        
        def helper(i):
            if i >= len(s):
                temp = part[:]
                res.append(temp)
                return
            for j in range(i, len(s)):
                if checkPalindrome(s[i:j+1]):
                    part.append(s[i:j+1])
                    helper(j+1)
                    part.pop()
        helper(0)
        return res
