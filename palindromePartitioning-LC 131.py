# Time Complexity = exponential = O(n * 2^n), coz we are checking at every point whether string is palindrome or not.n is the length of string


# For loop based Recursion with Backtracking
class Solution:
    def partition(self, s: str) -> list[list[str]]:
        if s == None:
            return [[]]
        
        self.result = []
        
        self.helper(s, 0, [])
        
        return self.result
    
    
    def helper(self, s, index, path):
        # Base case
        if index == len(s):
            self.result.append(path.copy())
        
        # Logic
        for i in range(index, len(s)):
            if (self.isPalindrome(s, index, i)):
                # Action
                # Append the palindrome substring to path
                path.append(s[index: i+1])
                
                # Recurse
                self.helper(s, i + 1, path)
                
                # Backtrack
                path.pop(len(path) - 1)
                
        
        
        
    def isPalindrome(self, s, left, right):
        while (left < right):
            if s[left] != s[right]:
                return False
            
            # Move left and right indexes towards each other to find if tehre is any other palindrome substring
            left += 1
            right -= 1
            
        return True
    
   
    
    
    
    
    
# For loop based Recursion without Backtracking
class Solution:
    def partition(self, s: str) -> list[list[str]]:
        if s == None:
            return [[]]
        
        self.result = []
        
        self.helper(s, 0, [])
        
        return self.result
    
    
    def helper(self, s, index, path):
        # Base case
        if index == len(s):
            self.result.append(path)
        
        # Logic
        for i in range(index, len(s)):
            if (self.isPalindrome(s, index, i)):
                # Action
                # Append the palindrome substring to newlist, which is a copy of path
                newlist = path.copy()
                newlist.append(s[index: i+1])
                
                # Recurse
                self.helper(s, i + 1, newlist)
                
        
        
        
    def isPalindrome(self, s, left, right):
        while (left < right):
            if s[left] != s[right]:
                return False
            
            # Move left and right indexes towards each other to find if tehre is any other palindrome substring
            left += 1
            right -= 1
            
        return True
    
    
    
    
# For loop based Recursion with Backtracking(passing only substring in helper)
class Solution:
    def partition(self, s: str) -> list[list[str]]:
        if s == None:
            return [[]]
        
        self.result = []
        
        self.helper(s, [])
        
        return self.result
    
    
    def helper(self, s, path):
        # Base case
        if len(s) == 0:
            self.result.append(path.copy())
        
        # Logic
        for i in range(0, len(s)):
            if (self.isPalindrome(s, 0, i)):
                # Action
                # Append the palindrome substring to path
                path.append(s[0: i+1])
                
                # Recurse
                # The substring to be passed is the one after the plaindrome substring
                self.helper(s[i+1: ], path)
                
                # Backtrack
                path.pop(len(path) - 1)
                
        
        
        
    def isPalindrome(self, s, left, right):
        while (left < right):
            if s[left] != s[right]:
                return False
            
            # Move left and right indexes towards each other to find if tehre is any other palindrome substring
            left += 1
            right -= 1
            
        return True
    