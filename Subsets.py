# Time Complexity : O(n)
#Space Complexity : O(n^2)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO
class Solution:
    def __init__(self):
        self.answer = list()
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums, 0, [])
        return self.answer
    def helper(self, nums, idx, currentSet):
        if idx == len(nums):
            self.answer.append(currentSet)
            return

        currentSet.append(nums[idx])
        self.helper(nums, idx+1, list(currentSet))
        currentSet.pop()
        self.helper(nums, idx+1, list(currentSet))
