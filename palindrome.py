# Time complexity: O(n^n) where n is the length of the string
# Space complexity: O(length of string)
# Approach: backtracking 
# use for loop based recursion by having possibilities of choosing element by appending one by one
# two by two, until length by length
# using all the possibilities,
# run a for loop with recursion and check if the added possibilitity is a palindrome.
# if palindrome, then proceed further- do recursion and backtrack
# else do not got further




class Solution:
    result =[]
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if len(s)== 0:
            return self.result
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, index, path):
        #base:
        if index == len(s):
            self.result.append(path.copy())
        
        
        #logic
        #action
        for i in range(index, len(s)):
            if(self.palindrome(s,index,i)):
                path.append(s[index:i+1])
        
        #recursion
                self.helper(s,i+1,path)
        
        #backtrack
                path.pop()
    def palindrome(self,s, left, right):
        while left <= right:
            if s[left]!=s[right]:
                return False
            left += 1
            right -= 1
        return True
        