# Backtracking-2

## Problem1 
# Subsets (https://leetcode.com/problems/subsets/)

# Solved Subsets using the classic choose/not-choose backtracking pattern:
# At each index, make two recursive calls:
# Not choose current element → skip it (idx + 1, path unchanged)
# Choose current element → add to path, then recurse (idx + 1)
# Base case: When idx == len(nums), add current path to results
# Backtrack: Remove last added element after "choose" branch to restore state

# Time Complexity: O(2^N) — generate all subsets
# Space Complexity: O(N) — recursion depth + path storage
# 💡 Key insight: This binary decision tree (include/exclude each element) naturally generates all 2^N subsets without duplicates. 
# The same pattern works for any "generate all combinations" problem!

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums, 0, [])
        return self.res
    
    def helper(self, nums, idx, path):
        # base
        if idx == len(nums):
            self.res.append(list(path))
            return

        # recursion
        #dont choose
        self.helper(nums, idx + 1, path)

        # choose
        path.append(nums[idx])
        self.helper(nums, idx + 1, path)

        # backtrack
        path.pop()



## Problem2

# Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)


# Recursive partitioning: At each position pivot, try all possible substrings s[pivot:i+1]
# Prune invalid paths: Only recurse if substring is a palindrome (checked via two-pointer method)
# Build solution: Add valid palindromes to path, recurse on remaining string (i+1), then backtrack
# Base case: When pivot == len(s), add current path to results

# Time Complexity: O(N * 2^N) — worst case checks all partitions, each palindrome check is O(N)
# Space Complexity: O(N) — recursion depth + path storage

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(0,s,[])
        return self.res
        
    def isPalindrome(self,s):
        if len(s) <= 1:
            return True
        i = 0
        j = len(s)-1
        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
    
    def helper(self,pivot,s,path):
        if pivot == len(s):
            self.res.append(list(path))
            return

        for i in range(pivot,len(s)):
            sub = s[pivot:i+1]
            if self.isPalindrome(sub):
                path.append(sub)
                self.helper(i+1, s, path)
                path.pop()
        
            
            
                
                
            





