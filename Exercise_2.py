# S30 Problem #73 Palindrome Partitioning
#LeetCode #131 https://leetcode.com/problems/palindrome-partitioning/description/ 

# Author : Akaash Trivedi
# Time Complexity : O(N * 2^N) 2^N for creating substring and N for palindrome check
# Space Complexity : O(n) n -> length of the string
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# for loop based recursion with backtracking
# create all the substring from pivot to i in for loop
# for each substring check for palindrome
# if palindrome add it to path and recursively call helper making pivot i+1
# Add path to result if reach end of string, valid partition is formed
# backtrack at each level and pop last substring from the path to explore other partitions 

class Solution:
    def __init__(self):
        self.result = []

    def partition(self, s: str) -> List[List[str]]:
        if not s or len(s) == 0:
            return []
        self.helper(s, 0, [])
        return self.result
    
    # helper funtion to do recursion on substring
    def helper(self, s, pivot, path)-> None:
        #base
        if pivot == len(s):
            self.result.append(path.copy())
            return

        #logic
        for i in range(pivot, len(s)):
            
            currPath = s[pivot:i+1]# substring take one extra element so i+1

            if self.isPalindrome(currPath, 0, len(currPath)-1):
                path.append(currPath) 

                #recurse
                self.helper(s, i+1, path)

                # backtrack
                path.pop()

    # function to check palindrome of given string
    def isPalindrome(self, s, l, r) -> bool:
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True