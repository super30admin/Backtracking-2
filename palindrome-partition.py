# Time Complexity: Exponential
# Space Complexity: Exponential
# Approach: Solved using backtracking. In the rucursive function, pick every substring of s and check if it is a palindrome.
# Call the recursive function with every substring that is a palindrome. 
# Use index to keep track of the remaining subproblem. 
# Call the recursive problem exhaustively till the string reaches end index.

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = []
        def isPalindrome(st):
            return st == st[::-1]
        
        def helper(S, slate):
            # Base
            if not S:
                res.append(slate[:])
                return
            
            # Recursive
            for index in range(len(S)):
                if isPalindrome(S[:index+1]):
                    slate.append(S[:index+1])
                    helper(S[index+1:], slate)
                    slate.pop()
                    
        helper(s,[])
        return res