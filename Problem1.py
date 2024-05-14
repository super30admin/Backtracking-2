## Problem1 
# Subsets (https://leetcode.com/problems/subsets/)

# Approach
# Call helper function with pivot as 0 and empty list. Add path's deep copy to the res list.
# for i from pivot to len(nums), append nums[i] to path. call helper function with pivot as i+1 and curr path
# At each step, add path's deep copy to res. if pivot == len(nums): return. Backtrack by popping the last element from path. Return result

# Time Complexity: O(2**n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def helper(self,nums,pivot,path):
        # base
        self.res.append(path[:])
        print('res',self.res)
        if pivot == len(nums):
            return

        # logic
        
        for i in range(pivot,len(nums)):
            path.append(nums[i])
            print('path',path)
            self.helper(nums,i+1,path)
            path.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums,0,[])
        return self.res