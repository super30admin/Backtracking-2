"""
Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)


"""
# Approach - 1
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        For loop based recursion, by taking all possible substring.
        Time Complexity: O(N2^N): N is the len of the string
        Space Complexity : O(N)
        """
        result = []
        if s =="" or len(s) == 0: return result
        
        
        def helper(s, idx, path):
            # Base Condition
            if idx == len(s): 
                result.append(list(path))
                return
            
            # Logic
            for i in range(idx, len(s)):
                sub_s = s[idx : i + 1]
                
                # check if the substring is a palindrome
                if self.is_palindrome(sub_s):
                    # if it is a palindrome then we will add the substring to the path
                    # Action
                    path.append(sub_s)
                    # we will recurse through teh function again
                    # Recurse
                    helper(s, i + 1, path)
                    # Backtrack
                    path.pop()    
        
        helper(s, 0, [])
        return result
    
    def is_palindrome(self, st):
        """
        Basic palindrome check function
        """
        s , e= 0, len(st) - 1
        
        while s < e:
            if st[s] != st[e]:
                return False
            else:
                s += 1
                e -= 1
        return True
            
# Approach - 2
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        Without taking the pivot and fixing it at 0 index
        Timne an dSpace both same
        """
        result = []
        if s =="" or len(s) == 0: return result
        
        
        def helper(s, path):
            # Base Condition
            if len(s) ==0: 
                result.append(list(path))
                return
            
            # Logic
            for i in range(0, len(s)):
                sub_s = s[0 : i + 1]
                
                # check if the substring is a palindrome
                if self.is_palindrome(sub_s):
                    # if it is a palindrome then we will add the substring to the path
                    # Action
                    path.append(sub_s)
                    # we will recurse through teh function again
                    # Recurse
                    helper(s[i + 1 :], path)
                    # Backtrack
                    path.pop()
            
        
        
        helper(s, [])
        return result
    
    def is_palindrome(self, st):
        """
        Basic palindrome check function
        """
        s , e= 0, len(st) - 1
        
        while s < e:
            if st[s] != st[e]:
                return False
            else:
                s += 1
                e -= 1
        return True
            
        
        