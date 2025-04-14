""""
Approach: At each step, we either skip partitioning at the current index or, if the substring from start to end is a palindrome, make a partition, update start = end + 1, and start a new substring.
TC: O(n*2^n) There can be 2^n palindromic substrings in the worst case and it takes n time to form the substring and copy to res
SP: O(n) size of call stack space will be length of string in the worst case

"""
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s, l, r):
            while l <r:
                if s[l]!=s[r]:
                    return False
                l+=1
                r-=1
            return True
        res = []
        part = []
        def dfs(start):
            if start>=len(s):
                res.append(part[:])
            for end in range(start, len(s)):
                if isPalindrome(s, start, end):
                    part.append(s[start:end+1])
                    dfs(end+1)
                    part.pop()
        dfs(0)
        return res
        