# ## Problem2

# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

# S1: RQ
# S2: Constraints
# S3: Test Cases
# S4: Solution without Code
# 0-1 solution
# S5: Solution with Code

class Solution:
    def partition(self, s):
        self.result = []
        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        # base
        if pivot == len(s):
            self.result.append(list(path))
            return

        for i in range(pivot, len(s)):
            # action
            substr = s[pivot:i+1]
            if self.isPalindrome(substr):
                path.append(substr)
                # recurse
                self.helper(s, i + 1, path)
                # backtrack
                path.pop()

    def isPalindrome(self, substr):
        start = 0
        end = len(substr) - 1
        while start <= end:
            if substr[start] != substr[end]:
                return False
            start += 1
            end -= 1
        return True


s = "aab"
sol = Solution()
print(sol.partition(s))
