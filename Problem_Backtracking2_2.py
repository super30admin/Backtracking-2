class Solution:
    def partition(self, s: str) -> List[List[str]]:
        length = len(s)
        dp = [[False for k in range(length)] for k in range(length)]
        ret = []
        self.dfs(ret, s, 0, [], dp)
        
        return ret
        
        
    def dfs(self, ret, s, start, currentList, dp):
        if start >= len(s):
            ret.append(list(currentList))
        
        for end in range(start, len(s)):
            if s[end] == s[start] and (end - start <= 2 or dp[start+1][end-1]):
                dp[start][end] = True
                currentList.append(s[start:end+1])
                self.dfs(ret, s, end + 1, currentList, dp)
                currentList.pop()
        

TC : O(N*2^N)

SC : O(N⋅N)