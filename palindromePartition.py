# Time Complexity : O(n * 2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use backtracking. For each index, try every substring s[i:j].
# If the substring is a palindrome, add it to the current partition and
# recursively process the remaining string. When we reach the end of the
# string, store the current partition in the result.



class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def check_palindrome(i,j):
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True

        def helper(i,arr):
            if i == len(s):
                res.append(arr[:])
                return 
            for j in range(i,len(s)):
                if check_palindrome(i,j):
                    arr.append(s[i:j + 1])
                    helper(j + 1,arr)
                    arr.pop()

        res = []
        helper(0,[])
        return res