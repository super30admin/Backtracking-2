# Time Complexity : O((2**n)*n) (2**n) for recursion and n for palindrome check
# Space Complexity : O(n) because of backtracking
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I recurse using for loop to recurse through string forming substring of s[0...] increasing index
# if the substring is palindrome we add it to the path, adding the path to result each time i goes beyond 
# length of string

# https://leetcode.com/problems/palindrome-partitioning

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        def helper(s, index, path):
            if index == len(s):
                result.append([x for x in path])
            for i in range(index, len(s)):
                if self.isPalindrome(s[index:i+1]):
                    path.append(s[index:i+1])
                    helper(s, i+1, path)
                    path.pop()
        helper(s, 0, [])
        return result
                    
    
    def isPalindrome(self, arr):
        left = 0
        right = len(arr)-1
        
        while left<=right:
            if arr[left] != arr[right]:
                return False
            left+=1
            right-=1
            
        return True