# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using bactracking. 1. Action is appending deepcopy of path to res list
# 2. Recurse calling helper function to get all the paths
# 3. Backtrack removing the elements from the path to get to the previous state to explore other combinations


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        if not nums:
            return self.res
        self.helper(nums, 0, [])
        return self.res

    def helper(self, nums, index, path):
        #base
        self.res.append(copy.deepcopy(path))
        #logic
        for i in range(index, len(nums)):
            #action
            path.append(nums[i])
            #recurse
            self.helper(nums, i + 1, path)
            #backtrack
            path.pop()