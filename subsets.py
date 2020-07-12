# Time Complexity : O(n*2^n), where n is the length of nums
# Space Complexity : O(n), only one list used.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This is a bactracking approach where all subsets are added, and
# along the way different subsets are created by keeping tack of
# the index and using that index to add and remove from the list.
class Solution(object):
    def __init__(self):
        self.retVal = []

    def subsets(self, nums):
        if not nums:
            return self.retVal
        self.backtrack(nums, 0, [])
        return self.retVal

    def backtrack(self, nums, idx, temp):
        # base
        self.retVal.append(list(temp))
        # iterate
        for i in range(idx, len(nums)):
            # action
            temp.append(nums[i])
            # recurse
            self.backtrack(nums, i + 1, temp)
            # backtrack
            temp.pop()
