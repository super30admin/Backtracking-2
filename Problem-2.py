#Approach
#0-1 recursion backtracting choose i pivot and consider the substring untill the index if it is palindrome explore that path else dont explore



#Complexity
#Time :o(2^n)
#Space: o(n)



from typing import List


class Solution:
    def __init__(self):
        self.result = []

    def isPalindrome(self, s):
        return s == s[::-1]

    def partition(self, s: str) -> List[List[str]]:
        palindrome = []
        self.helper(s, 0, palindrome)
        return self.result

    def helper(self, s, pivot, palindrome):
        if pivot == len(s):
            self.result.append(palindrome.copy())

        for i in range(pivot, len(s)):
            prefix_str = s[pivot:i + 1]
            if self.isPalindrome(prefix_str):
                palindrome.append(prefix_str)
                self.helper(s, i + 1, palindrome)
                palindrome.pop(-1)


