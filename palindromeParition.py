#Time Complexity: O(n!)
#Space Complexity: O(n ** 2)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def ispalindrome(s):
            
            return s == s[::-1]
        
        
        res = []
        def dfs(s, path):
            
            if len(s) == 0: 
                res.append(path)
                
            
            for i in range(len(s)):    
                if ispalindrome(s[:i+1]):
                    dfs(s[i+1:], path + [s[:i+1]])
                    
        
        dfs(s, [])
        
        
        return res