# Approach: Backtracking

# We will follow the same template that we kept following uptill now. We maintain an index and a cursor that keeps going ahead in string. We will append the substring between index and cursor to our inner temporary list if its a palindrome. After which we will move the index to next character and carry out the same operation. 

# In brief what we are doing is that every level we add a substring to the temporary list if its palindrome. If not we take a character from remaining substring append it to the last added character and check if that makes its a palindrome. We keep doing this for every level untill we exhaust the characters to add at that level.

# Here is a pictorization how it would look like

#                                                       "aaba"
#                    /                                  /           \          \
#               ["a"]"aba"                          ["aa"]"ba"  ["aab"]"a"   ["aaba"]"a"
#              /           \                    \
#          ["a","a"]"ba"   ["a", "a", "ab"]"a"  ["a","a", "aba"]

# Time complexity: Exponential
# Space complexity: O(n); where n = maximum length of the internal temporary list inside the resultant list.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if s == None or len(s) == 0:
            return result
        
        self.backtrack(s, 0, [])
        return self.result
        
    def backtrack(self, s, index, temp):
        # Base
        if index == len(s):
            self.result.append(temp.copy())
            return
        
        # Logic
        for i in range(index, len(s)):
            if(self.isPalindrome(s, index, i)):
                
                # Action
                temp.append(s[index: i+1])
                
                # Recurse
                self.backtrack(s, i + 1, temp)
                
                # Backtrack
                temp.pop()
                
    def isPalindrome(self, s, left, right):
        while left < right:
            if(s[left] != s[right]):
                return False
            
            left += 1
            right -= 1  
            
        return True