class Solution:
    #Solution 1
    def partition(self, s: str) -> List[List[str]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n * 2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = []
        self.helper(s, 0, '', [])
        return self.result
    
    def helper(self, s, idx, curr, path):
        #base
        if idx == len(s):
            self.result.append(path.copy())
            return
            
        #logic
        curr += s[idx]
        #not partition
        if idx != len(s) - 1:       #HAVE to add to the path if we are at end of the string
            self.helper(s, idx + 1, curr, path)
        
        #partition
        path.append(curr)
        if self.isPalindrome(curr):
            self.helper(s, idx + 1, '', path)
        
        #backtrack
        path.pop()
            
    def isPalindrome(self, s):
        low, high = 0, len(s) - 1
        
        while low <= high:
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        
        return True
    
    #Solution 2
    """
    def partition(self, s: str) -> List[List[str]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(n * 2^n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        self.result = []
        self.backtracking(s, 0, [])
        return self.result
    
    def backtracking(self, s, idx, path):
        #base
        if idx == len(s):
            self.result.append(path.copy())
            
        #logic
        for i in range(idx, len(s)):
            #action
            if not self.isPalindrome(s[idx:i+1]):
                continue
                
            path.append(s[idx:i+1])
            
            #recursion
            self.backtracking(s, i + 1, path)
            
            #backtracking
            path.pop()
            
    def isPalindrome(self, s):
        low, high = 0, len(s) - 1
        
        while low <= high:
            if s[low] != s[high]:
                return False
            low += 1
            high -= 1
        
        return True
    """