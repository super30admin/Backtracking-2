## Problem2

# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        Time Complexity: O(N * 2^N)
        - The Subsets (2^N): In the worst-case scenario where every substring is a palindrome 
          (e.g., "aaaa"), there are 2^(N-1) possible ways to partition the string. 
        - The Palindrome Check (N): For each of those possible partitions, we slice strings 
          and check if they are palindromes, taking O(N) time.
        - Total: O(N * 2^N), where N is the length of string s.

        Space Complexity: O(N)
        - Recursion Stack: The maximum depth of the recursive call stack is N (happens when 
          partitioned into single characters).
        - Path Variable: The 'path' array can hold a maximum of N strings at any given time.
        - Total: O(N) + O(N) = O(N). (Note: This excludes the space required to store the 
          final 'result' array).
        """
        
        # This will store all of our valid palindrome partitions
        result = []
        
        def helper(s, pivot, path):
            nonlocal result
            n = len(s)
            
            # --- BASE CASE ---
            # If our pivot reaches the end of the string (n), it means we have 
            # successfully partitioned the entire string into valid palindromes.
            if pivot == n:
                # We append a *copy* of the current path (using list()) because 
                # 'path' is a reference and will be modified by future recursive calls.
                result.append(list(path))
                return 
                
            # --- RECURSIVE LOGIC & BACKTRACKING ---
            # We iterate through the string starting from our current 'pivot'.
            # 'i' represents the ending index of the substring we are evaluating.
            for i in range(pivot, n):
                # Extract the current substring from pivot to i
                curr = s[pivot:i+1]
                
                # Check if the extracted substring is a palindrome
                if curr == curr[::-1]: 
                    # 1. CHOOSE: Add the valid palindrome to our current path
                    path.append(curr)
                    
                    # 2. EXPLORE: Recursively partition the rest of the string.
                    # The new starting point (pivot) for the remaining string is i + 1.
                    helper(s, i + 1, path)
                    
                    # 3. UN-CHOOSE (Backtrack): Remove the last added substring 
                    # so we can continue the loop and try longer substrings from the original pivot.
                    path.pop()
                    
        # Kick off the recursion starting at index 0 with an empty path
        helper(s, 0, [])
        return result