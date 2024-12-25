# Backtracking-2

## Problem1 :Subsets (https://leetcode.com/problems/subsets/)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start, path):
            result.append(path)
            for i in range(start, len(nums)):
                backtrack(i + 1, path + [nums[i]])

        result = []
        backtrack(0, [])
        return result

## Problem2: Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
class Solution(object):
    @cache  # the memory trick can save some time
    def partition(self, s):
        if not s: return [[]]
        ans = []
        for i in range(1, len(s) + 1):
            if s[:i] == s[:i][::-1]:  # prefix is a palindrome
                for suf in self.partition(s[i:]):  # process suffix recursively
                    ans.append([s[:i]] + suf)
        return ans
