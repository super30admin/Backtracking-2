#Time complexity: O(n * 2^n)
#Space complexity: O(n^2) as n for recursive stack and another n for every shallow copy made by s[:i]
#Works on leetcode: yes
#Approach: We use iterative-recursive backtracking where we iterate within recursive function through the length of s.
#At each iteration, we check if substring of s till ith position ispalindrome, if it is we call the recursive function
#using substring of from ith position and add to path the left substring. if s is empty, we add path to the result
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        def ispalindrome(s):
            return s==s[::-1]
        
        def dfs(s,path):
            if not s:
                ans.append(path)
                return 
            for i in range(1,len(s)+1):
                if ispalindrome(s[:i]):
                    dfs(s[i:], path+[s[:i]])
        dfs(s,[])
        return ans 