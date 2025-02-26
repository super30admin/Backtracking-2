# Problem 2 : Palindrome Partitioning
# Time Complexity : O(n* 2^n)
# Space Complexity : O(n* 2^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# For loop recursion with backtracking
import string
from typing import List
class Solution:
    # palindrome function to check if the string is palindorome
    def isPalindrome(self, s: string, start: int, end: int) -> bool:
        # loop from start to end of the string s
        while (start <= end):
            # if the charactet at start and end position are not equal then return false
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        # else return true
        return True

    def partition(self, s: str) -> List[List[str]]:
        # result variable will store the list of list of palindrome partitioning of s
        result = []
        # currPath variable will store the current list of palindrome partitioning of s
        currPath = []

        # recursion function to generate the combination of palindrome partitioning of s
        def helper(s: str, pivot: int, currPath: List[str]) -> None:
            # base case if the pivot is equal to length of strings 
            if pivot == len(s):
                # append the deep copy of the currPath to result
                result.append(currPath.copy())
                return 
            # for loop recursion from pivot position to end of the string s
            for i in range(pivot, len(s)):
                # get the substring from pivot index to i+1 index of the string
                subString = s[pivot:i+1]
                # check if the substring is palindrome 
                if(self.isPalindrome(subString, 0, len(subString)-1)):
                    # if it is palindrome then only append the subsring to currPath
                    currPath.append(subString)
                    # calling the helper function with i+1 since element should not be repeated 
                    helper(s, i+1, currPath)
                    # for backtracking removing the last element ie element at i position
                    currPath.pop()
        helper(s, 0, currPath)
        return result


# For loop recursion with deep copy 

class Solution:
    # palindrome function to check if the string is palindorome
    def isPalindrome(self, s: string, start: int, end: int) -> bool:
        while (start <= end):
            # if the charactet at start and end position are not equal then return false
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
         # else return true
        return True

    def partition(self, s: str) -> List[List[str]]:
        # result variable will store the list of list of palindrome partitioning of s
        result = []
        # currPath variable will store the current list of palindrome partitioning of s
        currPath = []

        # recursion function to generate the combination of palindrome partitioning of s
        def helper(s: str, pivot: int, currPath: List[str]) -> None:
            # base case if the pivot is equal to length of strings 
            if pivot == len(s):
                # append the currPath to result
                result.append(currPath)
                return 
            # for loop recursion from pivot position to end of the string s
            for i in range(pivot, len(s)):
                # get the substring from pivot index to i+1 index of the string
                subString = s[pivot:i+1]
                # check if the substring is palindrome 
                if(self.isPalindrome(subString, 0, len(subString)-1)):
                    # first get the deep copy of the currPath
                    currPathCopy = currPath.copy()
                    # append the substring to the deep copy 
                    currPathCopy.append(subString)
                    # calling the helper function with i+1 since element should not be repeated 
                    helper(s, i+1, currPathCopy)
        helper(s, 0, currPath)
        return result