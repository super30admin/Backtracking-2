# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)
TC: o(n)
SC: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start, subset):
            res.append(subset[:])
            for i in range(start, len(nums)):
                subset.append(nums[i])
                backtrack(i + 1, subset)
                subset.pop()
                
        res = []
        backtrack(0, [])
        return res
## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
TC:O(n*(2^n))
SC:O(n) 
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []  # final result to store all possible palindrome partitions
        curr_partition = []  # to store the current partition
        
        def is_palindrome(s, i, j):
            # check if substring s[i:j+1] is a palindrome or not
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True
        
        def backtrack(start):
            # base case: if we have traversed the whole string, add the current partition to the final result
            if start >= len(s):
                res.append(curr_partition.copy())
                return
            
            # for each character of the string, consider all possible substrings starting at the current character
            for end in range(start, len(s)):
                # check if the substring is a palindrome or not
                if is_palindrome(s, start, end):
                    # if it's a palindrome, add it to the current partition and recursively find all partitions that can be formed from the rest of the string
                    curr_partition.append(s[start:end+1])
                    backtrack(end+1)
                    curr_partition.pop()  # backtrack to remove the last added substring
        
        backtrack(0)  # start the recursive function from the first character of the string
        return res  # return the final result