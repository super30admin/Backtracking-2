class Solution:
    
    """
    DescriptionL Palindrome Partitioning
    from given string s find substrings which are palindrome
    
    Time Complexicity: O(n*L^n), where L -> length of the string
    Space Complexicity: O(n)
    
    works in leetcode: Yes
    
    Approach: Using backtracking (similar to problem 1)
    - made use of for loop instead
    - start the backtrack from index to end of the string in for loop
    """
    
    def partition(self, s: str) -> List[List[str]]:
    
        self.result = []
        if s == None or len(s) == 0: return self.result
            
        self.backtrack(s, 0, [])
        return self.result
    
    def backtrack(self, string, index, path):
        
        # Base
        if index == len(string): 
            self.result.append(copy.copy(path))
            return
        
        # Logic
        for i in range(index, len(string)):
            if self.isPalindrome(string, index, i):
                # Action
                path.append(string[index:(i + 1)])
                # Recurse
                self.backtrack(string, i + 1, path)
                # Backtrack
                path.pop()

    
    def isPalindrome(self, string, l, r):
        if l == r: return True
        while l < r:
            if string[l] != string[r]: return False
            l += 1; r -= 1
        return True
