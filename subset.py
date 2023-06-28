# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find all the subset using for loop based recursion and usnig backtrack find the feasible subset.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        self.helper(nums, 0, [], result)
        return result
    
    def helper(self, nums ,id, path, res):
        li=list(path)
        res.append(li)
        for i in range(id, len(nums)):
            #action
            path.append(nums[i])
            
            #recurse
            self.helper(nums, i+1, path, res)
            
            #backtrack
            path.pop()