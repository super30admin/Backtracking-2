# Time Complexity: O(2^n) because we are making 2 decisions at each node
# Space Complexity: O(n) because we are using a new list at each node
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this problem, we are using a for loop recursion to find all the subsets of the given array. 
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # for loop recursion
        if nums == None or len(nums) == 0: return []

        self.answer= []
        self.recurse(nums, 0, [])

        return self.answer

    def recurse(self, nums, index, path):
        self.answer.append(path)
        for i in range(index, len(nums)):
            newlist = [nums for nums in path]
            newlist.append(nums[i])
            self.recurse(nums, i+1, newlist)