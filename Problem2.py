"""

    Student : Shahreen Shahjahan Psyche
    Time : O(N^2*2^N)
    Space : O(N)

    This code ran for all the test cases in Leetcodee


"""

from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        # edge case
        if not s:
            return []
        
        # checking wheteher palindrome or not
        def isPalindrome(s, start, end):
            while(start<end):
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
            
        
        # backtracking
        def helper(s, pos, temp, result):
            
            # base case : reaching at the end of the string, we can just coppy the current temp and save it in resultant
            # array
            if pos >= len(s):
                result.append(list(temp))
            for i in range(pos, len(s)):
                if isPalindrome(s, pos, i):
                    # action
                    temp.append(s[pos:i+1])
                    # reecurse
                    helper(s, i+1, temp, result)
                    # backtrack
                    temp.pop()
                    
        result = []          
        helper(s, 0, [], result)
        
        return result
        