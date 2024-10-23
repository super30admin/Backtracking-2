# 131. Palindrome Partitioning
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def isPalindrome(s):
            l = 0
            r = len(s)-1

            while l <= r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1

            return True

        def helper(s,path):
            #base
            if len(s) == 0:
                result.append(list(path))
                return

            #logic
            for i in range(0, len(s)):
                sub = s[:i+1]
                if isPalindrome(sub):
                    path.append(sub)
                    helper(s[i+1:],path)
                    path.pop()

        helper(s,[])
        return result


        