# Time Complexity : O(2^n * n) -> For n length string, exponential partitions × (palindrome checks + creating substrings)
# Space Complexity : O(n^2) (substring creation and recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Backtracking. Iterate over the string and check if the string form pivot to i+1 is a palindrome or not
# If it is then 1. Action append substring to path as we found the substring that is a palindrome from pivot to i+1
# 2. Recurse calling the helper function by incrementing i by 1 to include the next character in string s
# 3. Backtrack to remove the element from path to explore all other paths that satisfy the palindrome condition


class Solution:
    def partition(self, s: str) -> list[list[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, pivot, path):
        #base
        if pivot == len(s):
            self.result.append(list(path))
            return
        #logic
        for i in range(pivot, len(s)):
            substring = s[pivot:i+1]
            if self.isPalindrome(substring):
                #action
                path.append(substring)
                #recurse
                self.helper(s, i+1, path)
                #backtrack
                path.pop()

    def isPalindrome(self, s):
        if not s:
            return False
        left = 0
        right = len(s)-1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True