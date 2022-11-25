#TC: 2 ^ n * n (since at each char we have 2 choices and palindrome function will take N)
#SC: n (for additional list)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        result = []
        sublist = []
        
        def dfs(i):
            if i == len(s):
                result.append(sublist.copy())
            for j in range(i, len(s)):
                if self.palindrome(s, i, j):
                    sublist.append(s[i:j+1])
                    dfs(j+1)
                    sublist.pop()
        dfs(0)
        return result
    
    def palindrome(self,s, i, j):
        while(i<=j):
            if s[i] != s[j]:
                return False
            else:
                i, j = i+1, j-1
        return True