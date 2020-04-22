"""
// Time Complexity : O(m*2^n) m-> target, n-> number of candidates
// Space Complexity : O(maxDepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
        Recursive approach + backtracking
        Global var -> all_palindromes 
        1) Base case -> if the pos is reached till end of string, add the list of palindromic substrings into outer list
        2) for i = 1 to n:
            Slice the string in all possible k combinations and call the partition recursively only for palindromic substring
"""


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        Recursive approach + backtracking
        Global var -> all_palindromes 
        1) Base case -> if the pos is reached till end of string, add the list of palindromic substrings into outer list
        2) for i = 1 to n:
            Slice the string in all possible k combinations and call the partition recursively only for palindromic substring
        """
        result = []
        final = []
        def isPalindrome(s,low,high):
            while low < high:
                if s[low]!=s[high]:
                    return False
                low+=1
                high-=1
            return True
            #return s == s[::-1]
        
        def partitionrec(s,pos):
            if pos == len(s):
                #we are exhausting the string, so we must have found some set of palindromic substrings
                final.append(result[::])
            for i in range(pos,len(s)):
                if isPalindrome(s,pos,i):
                    result.append(s[pos:i+1])
                    partitionrec(s,i+1)
                    result.pop()
        partitionrec(s,0)
        return final