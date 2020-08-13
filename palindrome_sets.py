class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def isPal(s):
            return s == s[::-1]
        def dfs(s, path, res):
            if not s:
                res.append(path)
                return
            for i in range(1, len(s)+1):
                if isPal(s[:i]):
                    dfs(s[i:], path+[s[:i]], res)
        dfs(s, [], res)
        return res

#Time-Complexity: O(N*2^N)
#Space-Complexity: O(N*2^N)