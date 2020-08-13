# Time Complexity : Incomplete
# Space Complexity : Incomplete
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Yes , couldn't finish it. Got confused with how to add tokens to partition and indexing while backtracking

# Your code here along with comments explaining your approach
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        result = []
        token = ""
        self.helper(s, token,0, [], result)
        return result
    
    def helper(self, s, token, index, partition, result):
        
        #isWorthExploring
        if index!=0 and index <= len(s):
            partition.append(token)
        
        #isValid
        if index>len(s):
            result.append(partition)
            return
            
      
        #backtrack
        for i in range(index, len(s)):
            token = s[i:index+1]
            if self.isPalindrome(token):
                self.helper(s, token, index+1, partition, result)
            else:
                partition.pop()
             
    def isPalindrome(self, s):
        
        for i in range(0, len(s)//2):
            if s[i] != s[len(s)-i-1]:
                return False
        
        return True