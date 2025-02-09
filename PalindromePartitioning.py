### RECURSIVE SOLUTION
# Time Complexity : exponential
# Space Complexity : O(n), recurive call stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:


class Solution(object):
    def __init__(self):
        self.result = []

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if s is None:
            return []

        self.result = []
        self.recurse(s, 0, [])
        return self.result
    
    def recurse(self, s, index, path):
        # base case
        if index == len(s):
            self.result.append(path)
            return

        # logic
        for i in range(index, len(s)):
            # substring at index
            substr = s[index:i+1]
            # check palindrome
            if(self.ispalindrome(s, index, i)):
                # copying path to new list and
                # addinng string to new list
                newlist = path[:]
                newlist.append(s[index:i+1])
                # checking for next substring
                self.recurse(s, i + 1, newlist)


    def ispalindrome(self, str, left, right):
        while left < right:
            # checking if left and right chars are same - palindrome
            if str[left] != str[right]:
                return False

            left += 1
            right -= 1

        return True


        