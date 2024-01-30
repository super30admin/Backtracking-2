'''

Time Complexity : O(2^n)
Space Complexity : O(2^n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We use for loop recursion, to form all possible substrings possible. Before adding the combination, we check it is a palindrome


'''


class Solution:
    @cache
    def partition(self, s: str) -> List[List[str]]:
        s = list(s)
        res = []

        def helper(s,i,curlist):
            nonlocal res

            if i == len(s):
                res.append(curlist.copy())
                return

            for a in range(i,len(s)):
                if s[i:a+1] == s[i:a+1][::-1]:
                    curlist.append(''.join(s[i:a+1]))
                    helper(s,a+1,curlist)
                    curlist.pop()

        helper(s,0,[])
        return res


