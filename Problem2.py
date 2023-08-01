
'''
Problem: Palindrome Partitioning
Time Complexity: O(2 ** n), where n is size of string
Space Complexity: O(n)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        applied for loop based recursion with backtracking   
'''

class Solution:
    def isPalindrome(self, s):
        i = 0
        j = len(s)-1

        while i <= j:
            if s[i]==s[j]:
                i+=1
                j-=1
            else:
                return False
        return True

    def partition(self, s: str) -> List[List[str]]:
        result = []

        def backtrack(s, pivot, path):
            #base
            if pivot == len(s):
                result.append(path[:])
                return 

            #logic
            for i in range(pivot, len(s)):
                substr = s[pivot:i+1]
                if self.isPalindrome(substr):
                    path.append(substr)
                    backtrack(s, i+1, path)
                    path.pop()

        backtrack(s, 0, [])
        return result

