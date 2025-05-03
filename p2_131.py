# 131. Palindrome Partitioning

# TC : O(N * 2^N), where N is the length of the string
    # There are 2^(N-1) possible ways to partition a string of length N
    # For each partition, we need O(N) time to check if each substring is a palindrome
    # The backtracking process explores all possible partitions
# SC : O(N), not counting the output
    # The recursion stack can go up to depth N in the worst case
    # The current_partition list can have at most N elements (when each character is a separate palindrome)

# Did this code successfully run on Leetcode : Yes

# Approach :
# Build a Solution Incrementally: We start from the beginning of the string and try to form palindrome substrings.
# Use Recursion: For each valid palindrome substring found, we recursively solve the problem for the rest of the string.
# Backtrack When Needed: After exploring one path, we backtrack to try other possibilities.
# The key insights are:
    # Every valid partition consists only of palindrome substrings
    # We can use backtracking to explore all possible ways to cut the string
    # The is_palindrome function efficiently checks if a substring is a palindrome


from ast import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # Function to check if a string is a palindrome
        def is_palindrome(start, end):
            # Check if substring s[start:end+1] is a palindrome
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
        
        # List to store all valid palindrome partitions
        result = []
        # Current partition being built
        current_partition = []
        
        # Backtracking function to find all palindrome partitions
        def backtrack(start_idx):
            # Base case: if we've processed the entire string
            if start_idx >= len(s):
                # Add a copy of the current partition to result
                result.append(current_partition[:])
                return
            
            # Try all possible substrings starting from start_idx
            for end_idx in range(start_idx, len(s)):
                # Check if the current substring is a palindrome
                if is_palindrome(start_idx, end_idx):
                    # Add this palindrome substring to our current partition
                    current_partition.append(s[start_idx:end_idx + 1])
                    # Recursively find partitions for the rest of the string
                    backtrack(end_idx + 1)
                    # Backtrack by removing the last added substring
                    current_partition.pop()
        
        # Start the backtracking process from index 0
        backtrack(0)
        return result