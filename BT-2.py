# Backtracking-2

## Problem 1 Subsets (https://leetcode.com/problems/subsets/)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums == None or len(nums) == 0:
            return []
        self.result = []
        self.backtrack(nums, 0, [])
        return self.result
    def backtrack(self, nums: List[int], index: int, path: List[int]) -> None:
        self.result.append([num for num in path])
        for i in range(index, len(nums)):
            #action
            path.append(nums[i])
            #recurse
            self.backtrack(nums, i+1, path)
            #backtrack
            path.pop()

## Problem 2 Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s == None or len(s) == 0:
            return []
        self.result = []
        self.backtrack(s, [])
        return self.result
    def backtrack(self, s: str, path: List[int]) -> None:
        #base
        if len(s) == 0:
            self.result.append([num for num in path])
            return
        #logic
        for i in range(len(s)):
            sub = s[:i+1]
            if self.isPalindrome(sub):
                #action
                path.append(sub)
                #recurse
                self.backtrack(s[i+1:], path)
                #backtrack
                path.pop()
    def isPalindrome(self, s:str) -> bool:
        return s == s[::-1]
