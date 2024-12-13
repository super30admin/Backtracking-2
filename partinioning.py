# The partition method finds all possible palindrome partitions of a string.

# Step 1: Backtracking Helper (dfs)
#   - If the index reaches the end of the string, append the current partition to the result.
#   - Iterate over all substrings starting from the current index:
#       - If the substring is a palindrome, add it to the current partition, recursively continue, and backtrack.

# Step 2: Palindrome Check (isPali)
#   - Check if a substring is a palindrome by comparing characters from both ends.

# Step 3: Return Result
#   - Return 'res', containing all palindrome partitions.

# TC: O(n * 2^n) - Substring checks and backtracking over all partitions.
# SC: O(n) - Space for the recursion stack and partitions.


from typing import List


class Solution:
    
    def partition(self, s: str) -> List[List[str]]:
        res, part = [], []

        def dfs(i):
            if i >= len(s):
                res.append(part.copy())
                return
            for j in range(i, len(s)):
                if self.isPali(s, i, j):
                    part.append(s[i : j + 1])
                    dfs(j + 1)
                    part.pop()

        dfs(0)
        return res

    def isPali(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l, r = l + 1, r - 1
        return True