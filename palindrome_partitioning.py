# Approach:
# This problem can be solved using backtracking. We will try to partition the 
# string into substrings and check whether each substring is a palindrome. If it is,
# we recursively try to partition the rest of the string. The base case is when we 
# have processed the entire string, and all substrings in the current partition are palindromes.
# For palindrome checking, we use a helper function that verifies if a string is a palindrome.

# Time Complexity: O(2^n * n), where n is the length of the string. In the worst case, 
# we generate all possible partitions, and for each partition, we check if each substring 
# is a palindrome, which takes O(n) time.
# Space Complexity: O(n), where n is the length of the string. The space complexity 
# comes from the recursion stack and the storage of valid partitions.

# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No, the approach follows standard 
# backtracking principles and palindrome checking.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # List to store the valid palindrome partitions
        result = []
        
        # Helper function to check if a string is a palindrome
        def is_palindrome(sub):
            return sub == sub[::-1]
        
        # Helper function for backtracking
        def backtrack(start, path):
            # If we've reached the end of the string, add the current partition to result
            if start == len(s):
                result.append(path[:])
                return
            
            # Try all possible partitions starting from the 'start' index
            for end in range(start + 1, len(s) + 1):
                # Get the substring
                substring = s[start:end]
                
                # If the substring is a palindrome, continue with the backtracking
                if is_palindrome(substring):
                    path.append(substring)  # Add the palindrome substring to the current partition
                    backtrack(end, path)  # Recurse to process the rest of the string
                    path.pop()  # Backtrack to try other possible partitions

        # Call the backtracking function starting from index 0 with an empty path
        backtrack(0, [])
        
        return result
