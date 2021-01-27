# Approach: Similar to the backtracking approach we have used, fix the pivot and move i from pivot onwards doing the partitions.
# Also at each level, check if palindrome and only the proceed
# Time: O(2 ^ N * N * N) ~= O( 2^N * N^2)
# O(2^N) comes from taking 2 choices similar to the tree, O(N) for palindrome check and another O(N) for deep copying the result
# Space - O(N) since we are doing it by backtracking, avoiding the deep copying at every time

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        self.result = []
        
        if not s or len(s) == "":
            return self.result
        
        self.helper(s, 0, [])
        return self.result
    
    
    def helper(self, string, index, paths):
        
        # base case
        if index == len(string):
            self.result.append(paths.copy())
            return 
        
        
        # logic
        for i in range(index, len(string)):
            
            if self.isPalindrome(string, index, i):
                #action
                paths.append(string[index: i+1])
                
                #recurse
                self.helper(string, i + 1, paths)
                
                #backtrack
                paths.pop()
                
    def isPalindrome(self, string, left, right):
        
        while left < right:
            if string[left] != string[right]:
                return False
            
            left += 1
            right -= 1
            
        return True
                
        