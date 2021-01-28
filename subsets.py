# Time Complexity : O(2^n)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        if not nums:
            return res
        
        self.helper(nums, [], 0, res)
        
        return res
    
    def helper(self, nums, temp, index, res):
        #choose all 
        res.append(list(temp))
        #logic
        for i in range(index, len(nums)):
            #choose/action
            temp.append(nums[i])
            #explore/recurse
            self.helper(nums, temp, i+1, res)
            #unchoose/backtrack
            temp.pop()