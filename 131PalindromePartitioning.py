class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        part = []
        def dfs(i):
            if i >= len(s):
                res.append(part.copy())
                return
            for j in range(i, len(s)):
                if self.helper(s, i ,j):
                    part.append(s[i:j+1])
                    dfs(j + 1)
                    part.pop()
                    
        dfs(0)
        return res
    def helper(self, s , l , r):
        while l < r:
            if s[l] != s[r]: 
                return False
            l = l + 1
            r = r - 1 
            
        return True
    
    
# T.C => 2 ** n=> It grows exponentially since its the length of ht estring and partioning it
# S.C => O(n) => O(N) => recursive stack space.
# Approach => Here first we create a partioning of a string in various possible subsrting and check each of it weather its a palindrome. 
# Its a chode of index plus one but not the same element to choose it. 