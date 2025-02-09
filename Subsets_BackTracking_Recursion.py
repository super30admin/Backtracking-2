# Time Complexity : exponential
# Space Complexity : O(n), because we are creating a new list and copying elements only when target == 0, else using 1 list only at every recursive call
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using backtracking approach because in this solution we will not have to use a new list at every recursive call
# 0 - 1 based recusion, along with backtracking technique
# when we dont pick an element to put in the subset list, the index increase by 1 and the path list (subset list) remains the same
# when we pick at element, the index increases by 1 after adding the elemnt in path list
# then we backtrack and remove the last element from the list
# when we have traversed the complete lists, we will reach the end of it, then we will create a new list
# copy the elements of path to it, and add it to result

class Solution(object):
    def __init__(self):
        self.result = []

    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        if nums is None:
            return []
        
        # all possible subsets - all possible combinations
        # recursion based solution

        self.recurse(nums, 0, [])
        return self.result
    
    def recurse(self, nums, index, path):
        # base case
        if index == len(nums):
            newlist = path[:]
            self.result.append(newlist)
            return

        # logic

        # 0 case - dont pick the element
        self.recurse(nums, index + 1, path)

        # action
        path.append(nums[index])
        # 1 case - pick the element case
        self.recurse(nums, index + 1, path)
        # backtrack
        path.pop()

        