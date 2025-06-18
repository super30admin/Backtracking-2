"""
Problem: subsets
Approach: At each node choose or don't choose. Solve recursively
t.c. => O(n * 2^n)
s.c. => O(n)
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        n = len(nums)
        def helper(index):
            if index == n:
                res.append(path.copy())
                return 
            path.append(nums[index])
            helper(index + 1)
            path.pop()
            helper(index + 1)
        helper(0)
        return res