#  Time Complexity : O(2^n)
#  Space Complexity : O(n) deep copy of every path
#  Did this code successfully run on Leetcode :yes

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        def isPalindrome(s):
            return s==s[::-1]
        def helper(s, idx, path):
            if idx==len(s):
                result.append(list(path))
                return
            for i in range(idx, len(s)):
                if isPalindrome(s[idx:i+1]):
                    #action
                    path.append(s[idx:i+1])
                    #recurse
                    helper(s, i+1, path)
                    #backtrack
                    path.pop()
                    
        helper(s, 0, [])
        return result