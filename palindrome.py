//Time complexity: O(N X 2 power N)
//space complexity:O(N)
//Run on Leetcode: yes
//Any issues: No

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def backtrack(s, path):
            if len(s) == 0:
                res.append(path[:])
                return 
                
            for i in range(len(s)+1):
                if s[:i] == s[i-1::-1]:
                    path.append(s[:i])
                    backtrack(s[i:], path)
                    path.pop()
        res = []
        backtrack(s, [])
        return res