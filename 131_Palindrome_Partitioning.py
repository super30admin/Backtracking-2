# Leetcode problem link : https://leetcode.com/problems/palindrome-partitioning/
# Time Complexity:    O(n*2^n)
# Space Complexity:   O(n) for Backtracking
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
     1. Start from the first index and add to current path. Add current path to output at every instance
     2. If current string is palindrome then call backtracking recursively starting from next index and keep updating the path
     3. For loop will iterate through all elements in the input always starting from next index and going till end

'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        output = []
        self.backtrack(s,output,0,[])
        return output
    
    def backtrack(self,s,output,index,path):
        if index >= len(s):
            temp = [x for x in path]
            output.append(temp)
            return
        
        for i in range(index,len(s)):
            if(self.isPalindrome(s[index:i+1])):
                path.append(s[index:i+1])
                self.backtrack(s,output,i+1,path)
                path.pop()
    
    def isPalindrome(self,s):
        if not s:
            return False
        
        l = 0
        r = len(s) - 1
        
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
        