# Time Complexity : O(n*n^n)
# Space Complexity : O(n)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#use set to lookup the backtracking soln
class Solution(object):
    def partition(self, s):
        
        def isPalindrome(s):
            return s == s[::-1]
        
        lookup = set()
        
        def backtrack(s, curr, idx, output):
            if idx >= len(s):
                output.append(curr[:])
                return
            
            for i in range(idx, len(s)):
                temp = s[idx:i+1]
                if temp not in lookup and isPalindrome(temp):
                        lookup.add(temp)
                        curr.append(temp)
                        backtrack(s, curr, i+1, output)
                        curr.pop()
                elif temp in lookup:
                    curr.append(temp)
                    backtrack(s, curr, i+1, output)
                    curr.pop()
                
        
        
        output = []
        backtrack(s, [], 0, output)
        return output
