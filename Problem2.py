## Problem2

# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

# Approach
# Call recurssive function and pass pivot starting at 0. At each pass, check the string between pivot and i. Pass this stirng to isValidPalidrome function.
# if it is valid, add the curr_str to the path list. If pivot > len(s), append deep copy of path to result list
# After every recursion call, pop the last element from the path list. return result list

# Time Complexity: O(2**n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def validPalindrome(self, s):
        l = 0
        r = len(s)-1
        while(l<r):
            if s[l] == s[r]:
                l += 1
                r -= 1
            else:
                return False
        return True


    def helper(self, s, pivot, path):
        # base
        
        if pivot >= len(s):
            self.res.append(path[:])
            return

        # logic
        for i in range(pivot,len(s)):
            curr_str = s[pivot:i+1]
            if self.validPalindrome(curr_str):
                path.append(''.join(curr_str))

                self.helper(s,i+1,path)
                path.pop()

    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(s,0,[])
        return self.res