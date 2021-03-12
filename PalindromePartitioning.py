# TC: Exponential
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/palindrome-partitioning/)
# Approach: Start from 0th index of the string and consider substrings in increments of 1
# If the current substring is a palindrome then add it to the result and increment index further
# if the index crosses the length of the string that means that all the strings in the current partition are palindromes

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        self.result = []
        if s == None or len(s) == 0:
            return self.result
                
        self.backtrack(s, 0, [])
        
        return self.result
    
    def backtrack(self, s, index, temp):
        
        if index == len(s):
            self.result.append(temp.copy())
            return
        
    
        for i in range(index, len(s)):
            # check current substring is a palindrome
            if self.isPalindrome(s, index, i):
                # current substring is a palindrome so add it to temp
                temp.append(s[index : i + 1])
                # recurse
                self.backtrack(s, i + 1, temp)
                # backtrack
                temp.pop()
    
    # function to check palindrome           
    def isPalindrome(self, s, left, right):
        
            
        while left < right:
            if s[left] != s[right]:
                return False
            
            left += 1
            right -= 1
            
        return True
                
            
        
        
        
