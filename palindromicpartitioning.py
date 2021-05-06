# Time Complexity - O(N*2^N)
# Space Complexity - O(N)
# Check if each string can be a valid palindrome, by backtracking
class Solution(object):
    def __init__(self):
        self.output = []
    def isPalindrome(self,s):
        if(len(s)!=0):
            return s==s[::-1]
        return False
    
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.backtrack(s,0,[])
        return self.output
    def backtrack(self,s,index,path):
        #print(index,path)
        if(index >= len(s)):
            self.output.append(list(path))
            return
        for i in range(index,len(s)):
            if(self.isPalindrome(s[index:i+1])):
                path.append(s[index:i+1])
                self.backtrack(s,i+1,path)
                path.pop()