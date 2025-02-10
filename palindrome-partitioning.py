"""

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.


Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.


Time Complexity: O(2^N * N) - There are 2^N possible partitions, and each takes O(N) to check palindromes.
Space Complexity: O(N) (for recursion depth) + O(2^N * N) (to store results).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# Approach:
# 1. Used Depth-First Search (DFS) with backtracking to explore all possible palindrome partitions of the string.
# 2. At each index, check if the substring is a palindrome; if true, add it to the current partition and continue searching.
# 3. Backtrack by removing the last added substring once a partitioning path is fully explored.


class Solution:
    def partition(self, s: str) -> List[List[str]]:

        res = []
        partition = []

        def dfs(i):
            if i >= len(s):
                res.append(partition.copy())
                return

            for j in range(i, len(s)):
                if self.isPalindrome(s, i, j):
                    partition.append(s[i:j+1])
                    dfs(j+1)
                    partition.pop() 

        dfs(0)
        return res    
        

    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l, r = l + 1, r - 1

        return True

