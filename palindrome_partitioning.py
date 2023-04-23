# Time Complexity: O(n*2^n) because we are making 2 decisions at each node and checking if the subset is a palindrome
# Space Complexity: O(n) because we are using a new list at each node
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this problem we are use for loop recursion to get a subset and check if the subset is a palindrome. 
If so, we add it to the path and call the function again to create subsets from the rest of the string. 
If we do form a valid palindrome partition, we add it to the answer list.
"""

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s == None or len(s) == 0: return []
        self.answer = []
        self.s = s
        self.helper(index = 0, path = [])
        return self.answer

    def helper(self, index: int, path: list):
        for i in range(index, len(self.s)):
            curr_subset = self.s[index:i+1]
            if self.isPalindrome(curr_subset):
                path.append(curr_subset)
                self.helper(i+1, path)
                path.pop()

        if index == len(self.s):
            self.answer.append(path.copy())

    def isPalindrome(self, word):
        start = 0
        end = len(word) - 1
        while start < end:
            if word[start] != word[end]: return False
            start += 1
            end -= 1
        return True