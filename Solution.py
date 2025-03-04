'''
// Time Complexity :
# Problem 1 - O(2^n) where n is length of the candidates (Recursion and Backtracking)
# Problem 2 - O(n*2^n) where n is the length of each substring (Backtracking)
// Space Complexity :
# Problem 1 - O(2^n) as all elements are appended in a new array (Recursion)
            - O(n) for storing each path (Backtracking)
# Problem 2 - O(n) for storing each path in the result array
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Subsets
# Recursion
# Initialize two lists for the path and result, check for null condition
# Recursion function - Append the path into the index (this ensures be get a blank path for the first 
# case) and iterate over each element using a 0-1 recursion.
# Append the path to the result list whenever it reaches the bound condiiton.

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        path = []
        if nums == None or len(nums) == 0: return result
        self.helper(nums, 0, path, result)
        return result
    
    def helper(self, nums, idx, path, result):
        ##base
        if idx == len(nums):
            result.append(path)
            return
        ## logic
        self.helper(nums, idx+1, list(path), result)
        ## actions
        path.append(nums[idx])
        self.helper(nums, idx+1, list(path), result)

# Backtracking
# Initialize array of lists for result and path stack, check for initial condition and return empty 
# array.
# Helper function that consists of an pivot element, path and result array. 
# For loop based recusrion that will go over all the elements and generate list. Append the list before
# the for loop so that all the paths are maintained correctly.
# Return the result list of lists.

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        path = []
        if nums == None or len(nums) == 0:
            return result
        self.helper(nums, 0, path, result)
        return result
    
    def helper(self, nums, pivot, path, result):
        ##logic
        result.append(list(path))
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            ## recurse
            self.helper(nums, i+1, path, result)
            ## backtrack
            path.pop()

## Problem 2 - Palindrome Partitioning
# Initialize the result and path array.
# Define the Palindrome function to check if the first and last character of the string are the same
# and increment the left parameter and decrement the right parameter until they cross each other.
# Backtracking function - Base case: When length of the string is equal to length, append the path list 
# to the result array.
# Logic - Run a for loop on the pivot element to length of string and from each character check if the 
# substring (using the pivot and character index) is a Palindrome. Pop the path array.
# Return the result array that is list of lists.

class Solution(object):

    def __init__(self):
        self.result = []
        self.path = []

    def isPalindrome(self, s, l, r):
        if (r >= len(s)):
            return False
              
        while (l <= r):
            if (s[l] != s[r]):
                return False
            l += 1; r -= 1

        return True

    def helper(self, s, pivot):
        ## base
        if pivot == len(s):
            self.result.append(list(self.path))
            return
        ## logic
        for i in range(pivot, len(s)):
            if self.isPalindrome(s, pivot, i):
                ## action
                self.path.append(s[pivot: i+1])
                ## recurse
                self.helper(s, i+1)
                ## backtrack
                self.path.pop()

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if s == None or len(s) == 0:
            return self.result
        self.helper(s, 0)
        return self.result