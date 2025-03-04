'''
// Time Complexity : O(2 ^ n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        if not s: return res
        
        def isPalindrome(s):
            return s == s[::-1]
        
        def helper(pivot, path):
            if pivot == len(s):
                res.append(list(path))
            for i in range(pivot, len(s)):
                curPartition = s[pivot: i + 1]
                if isPalindrome(curPartition):
                    path.append(curPartition)
                    helper(i + 1, path)
                    path.pop()

        helper(0, [])
        return res