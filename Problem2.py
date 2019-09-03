# Time Complexity : O((length of string-1)*(2^length of string))
# Space Complexity : O(length of string)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def partition(self, s):
        res = []

        def backtracking(s, path):
            if len(s) == 0:
                res.append(path)
            for i in range(1, len(s) + 1):
                if s[:i] == s[:i][::-1]:
                    backtracking(s[i:], path + [s[:i]])

        backtracking(s, [])
        return res

# In this problem, I am going over lenght of strings starting from lenght1 to the lenght of string and am checking for palindrome.
# and if it is then I am going inside it. At last if length  is 0 then append to result then return back.