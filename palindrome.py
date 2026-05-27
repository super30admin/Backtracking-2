# Time Complexity : O(2^n * n) n: lenght of the string. 
# Space complexity :O(N) auxilary space for recursion stack.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Iterate through the string starting from a pivot index, generating substrings from pivot to every possible end index i
# If the substring is a palindrome, append it to the path and recursively partition the remaining string starting from i + 1
# Once the pivot reaches the end of the string, append a copy of the path to the results. Then, pop() the last substring to undo the choice and explore other branches.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s: str, pivot: int, path: list):
        if pivot == len(s):
            self.result.append(list(path))
            return

        for i in range(pivot,len(s)):
            substr = s[pivot:i+1]
            if self.isPalindrome(substr):
                #action
                path.append(substr)
                #recurse
                self.helper(s,i+1,path)
                #backtrack
                path.pop()

    def isPalindrome(self,s: str) -> bool:
        return s == s[::-1]