# Time Complexity : O(2^n)[n = number of elements in the list]
# Space Complexity : O(n) [n = number of element in the list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Start with an empty list and keep on add adding elemnts in the curr list iteartively
# 2. In each iteration recurse with the updated list and index
# 3. To save space and use the same list again pop the last element added after each recursive call
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(nums, start, curr):
            nonlocal res
            res.append([num for num in curr])
            for i in range(start, len(nums)):
                # action
                curr.append(nums[i])
                # recurse
                backtrack(nums, i+1, curr)
                # backtrack
                curr.pop()
        backtrack(nums, 0, [])
        return res 