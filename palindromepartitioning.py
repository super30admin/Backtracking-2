# Time Complexity : O(^2)
#Space Complexity : O(n^2)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        lst = []
        def palindrome(a):
            return a == a[::-1]
        def dfs(i,curr):
            if i == len(s):
                lst.append(curr)
                return 
            for j in range(i,len(s)):
                sol = s[i:j+1]
                if palindrome(sol):
                    dfs(j+1, curr + [sol] )
            return 
        dfs(0,[])
        return lst
            