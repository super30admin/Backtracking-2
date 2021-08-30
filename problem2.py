#time complexity: O(2^N)
#sapce compleixty: O(N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def dfs(s, path, res):
            if not s:
                res.append(path[:])
                return
            for i in range(1, len(s)+1):
                if s[:i] == s[i-1::-1]:
                    path.append(s[:i])
                    dfs(s[i:], path, res)
                    path.pop()        
        res = []
        dfs(s, [], res)
        return res
        