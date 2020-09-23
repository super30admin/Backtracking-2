# Time Complexity : O(N*(N^N))
# Space Complexity : O(N), without recursive stack; where N is the input size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        output = []
        path = []
        self.backtracking(output, s, 0, path)
        
        return output
    
    
    # output, input received, way to traverse(index), current path
    def backtracking(self, output, s, index, path):
        
        # base case
        if index >= len(s):
            output.append(list(path))
            return
        
        # recursion: for finding all possible combinations of strings
        for i in range(index, len(s)):
        
            temp = s[index:i+1]
            if(self.isPalindrome(temp)):
                
                #add to path
                path.append(temp)
                
                #make recursive call
                self.backtracking(output, s, i+1, path)
                
                #remove from path
                path.pop(len(path)-1)
        
    #two pointers approach to check if string is palindrome
    def isPalindrome(self, s):
        l = 0
        r = len(s)-1
        
        while l<r:
            if s[l] == s[r]:
                l+=1
                r-=1
            else:
                return False
        return True