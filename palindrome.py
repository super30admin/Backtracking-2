# TC: O(N * 2^N)
# SC: O(N^2)

class Solution:
    
    def __init__(self):
        
        self.dp = collections.defaultdict(list)
    
    def isPalindrome(self, s):
        
        start, end = 0, len(s) - 1
        
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
            
        return True
    
    def makePals(self, s):
        
        if s in self.dp:
            return
        
        
        for i in range(len(s)): 
            if self.isPalindrome(s[:i+1]):
                plist =  self.dp[s[i+1:]]
                
                if not plist:
                    self.dp[s].append([s[:i+1]])
                else:
                    for l in plist:
                        self.dp[s].append([s[:i+1]] + l)
                    
                
        
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.dp[""] = []
        
        for winSize in range(1, len(s) + 1):
            for i in range(len(s) - winSize + 1):
                
                self.makePals(s[i:i+winSize])

        
        return self.dp[s]
