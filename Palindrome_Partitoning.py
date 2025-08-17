#  Time Complexity : O(2^n * n) -> For n length string, exponential partitions × (palindrome checks + creating substrings)
#  Space Complexity : O(n * n ~ n^2) n for the substring and n for the recursion stack
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : The code finds all possible ways to partition a string such that every substring in the partition is a palindrome. Using backtracking, it explores substrings starting from a pivot index, and whenever a palindrome substring is found, it is added to the current path, then recursion continues. Once the end of the string is reached, the current path is added to the result, and isPalindrome checks validity for each substring.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, pivot, path):
        if pivot == len(s):
            self.result.append(list(path))
            return
        
        for i in range(pivot, len(s)):
            subStr = s[pivot:i+1]
            if self.isPalindrome(subStr):
                path.append(subStr)
                self.helper(s, i+1, path)
                path.pop()

    def isPalindrome(self, s):
        left = 0
        right = len(s) - 1

        while left < right:
            if s[left] != s[right]:
                return False

            left += 1
            right -= 1

        return True