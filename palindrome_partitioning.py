# Did this code successfully run on Leetcode : YES

# Approach
# exhaustive backtracking
# find all substrings, check if palindrome and continue

# TC: O(N * 2^N), palindrome checking O(N) for all 2^N substrings
# SC: O(N) for storing current partition

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(s, 0)
        return self.res
        
    def helper(self, s, i, partition=[]):
        if i >= len(s):
            self.res.append(list(partition))
        for j in range(i, len(s)):
            if self.isPalindrome(s[i:j+1]):
                # action
                partition.append(s[i:j+1])
                # recurse
                self.helper(s, j+1, partition)
                # backtrack
                partition.pop()
                
    def isPalindrome(self, s):
        l, r = 0, len(s)-1
        while l <= r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True