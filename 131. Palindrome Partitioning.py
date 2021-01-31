# // Time Complexity : O(2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
	# Use the pivot backtrack approach.
	# But recursion has to be made only if the sub string is palindrome

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        if not s: return self.res
        
        self.helper(s,0,[])
        return self.res
    
    def helper(self,s,index,path):
        if index == len(s):
            self.res.append(path.copy())
            return
        for i in range(index,len(s)):
            if s[index:i+1] == s[index:i+1][::-1]:
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop()