"""
Runtime Complexity: Exponential and it depends on the length of nums array. Because we check each substrings.
Space Complexity: we create a new list each time for the path and this can be reduced using backtrack solution
because we create the list only when the index is equal to length of nums.
Yes, the code worked on leetcode.
"""
#for loop based recursion without backtrack
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return [[]]
        self.result = []
        self.helper(s,0,[])
        return self.result
    
    def helper(self,s,index,path):
        if index == len(s):
            self.result.append(path)
        
        for i in range(index,len(s)):
            if self.isPalindrome(s,index,i):
                new = path.copy()
                new.append(s[index:i+1])
                self.helper(s,i+1,new)
    def isPalindrome(self,s,left,right):
        while(left<right):
            if s[left] != s[right]:
                return False
            left+=1
            right-=1
        return True

#for loop based recursion using backtrack
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return [[]]
        self.result = []
        self.helper(s,0,[])
        return self.result
    
    def helper(self,s,index,path):
        if index == len(s):
            self.result.append(path.copy())
        
        for i in range(index,len(s)):
            if self.isPalindrome(s,index,i):
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop(len(path)-1)
    def isPalindrome(self,s,left,right):
        while(left<right):
            if s[left] != s[right]:
                return False
            left+=1
            right-=1
        return True
                
        

                
        