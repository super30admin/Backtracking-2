# Time Complexity : O(n. 2^n)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The approach here to do a backtrack using the iterative for loop approach. But before continuing the recursion, check if the
# substring is a palindrome or not.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def backtrack(pivot, path):
            # Base case
            if pivot == len(s):
                result.append(path.copy())
                return
            # Logic
            for i in range(pivot, len(s)):
                subString = s[pivot: i + 1]
                if isPalindrome(subString):
                    path.append(subString)
                    backtrack(i + 1, path)
                    path.pop()

        def isPalindrome(currStr):
            p1 = 0
            p2 = len(currStr) - 1

            while (p1 <= p2):
                if currStr[p1] != currStr[p2]:
                    return False
                p1 += 1
                p2 -= 1
            return True

        backtrack(0, [])
        return result

