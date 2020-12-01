# Backtrack solution
# Time complexity - O(n*2^n)
# Space complexity - O(2^n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.palindrome_partitions = []
        self.backtrack(s, 0, [])
        return self.palindrome_partitions

    def backtrack(self, s, start, partition_list):
         # base case
        if start == len(s):
            self.palindrome_partitions.append(list(partition_list)) # creates a new list while copying # space for output is not counted as extra space.
            return 
        
        # logic 
        for idx in range(start, len(s)):
            if self.isPalindrome(s, start, idx):
                # action
                partition_list.append(s[start:idx+1])
                # recurse
                self.backtrack(s, idx+1, partition_list)
                # backtrack
                partition_list.pop()
    
    
    # check whether the substring is a palindrome.
    def isPalindrome(self, s, i, j):
        while i<j:
            if s[i]!=s[j]:
                return False
            i+=1
            j-=1
        return True
        
    
# Recursive solution
# Time complexity - O(n*2^n)
# Space complexity - O(n*2^n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.palindrome_partitions = []
        self.recursive(s, 0, [])
        return self.palindrome_partitions

    def recursive(self, s, start, partition_list):
         # base case
        if start == len(s):
            self.palindrome_partitions.append(partition_list) # creates a new list while copying # space for output is not counted as extra space.
            return 
        
        # logic 
        for idx in range(start, len(s)):
            if self.isPalindrome(s, start, idx):
                # create a temporary list.
                temp = list(partition_list) # O(n)
                temp.append(s[start:idx+1])
                # recursive call
                self.recursive(s, idx+1, temp)
                
    # check whether the substring is a palindrome.
    def isPalindrome(self, s, i, j):
        while i<j:
            if s[i]!=s[j]:
                return False
            i+=1
            j-=1
        return True
        
        