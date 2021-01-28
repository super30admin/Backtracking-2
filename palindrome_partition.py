# Time Complexity : O(N * N * 2^N) O(N) - checking palindrome ability and O(2^N) since we have a two choice in recursive tree and O(N) for substring
# Space Complexity : O(N) Take space in backtracking
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def partition(self, s):
        self.result = []
        
        if not s or len(s) == "":
            return self.result
        
        self.backtrack(s, 0, [])
        return self.result
    
    def backtrack(self, string, index, path):
        #Base
        if index == len(string):
            self.result.append(list(path))
            return 
        
        #Logic 
        for i in range(index, len(string)): # not from zero, from index(that is index)
            if self.checkPalindrome(string, index, i):        
                #action
                path.append(string[index: i+1]) # in slicing i+1 is not added
                #recurse
                self.backtrack(string, i+1, path)
                #backtrack
                path.pop()

    
    # Palindrome check 
    def checkPalindrome(self, string, left, right):
        if left == right:
            return True
        while left < right:
            if string[left] != string[right]:
                return False
            
            left += 1
            right -= 1
            
        return True
