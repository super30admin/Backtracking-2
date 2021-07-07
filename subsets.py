# Time Complexity : Exponential
# Space Complexity : Recursive Stack O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        self.backtrack(nums, 0, [])
        return self.result
    
    def backtrack(self, nums, index, tempList):
        # Base Case
        if index > len(nums):
            return
        
        # Logic
        self.result.append(tempList[:])
        for i in range(index, len(nums)):
            tempList.append(nums[i])
            self.backtrack(nums, i+1, tempList)
            tempList.pop()