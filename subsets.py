# Time Complexity : Explonential unable to figure out
# Space Complexity : O(N*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.helper(nums, 0, [], result)
        return result
             
    def helper(self, nums, index, subset, result):
        
        #isValid
        if index == 0:
            result.append([])
            
        if index!=0 and index <= len(nums):
            sub = []
            for x in subset:
                sub.append(x)
            result.append(sub)
            
        
        #isWorthExploring
        if index > len(nums):
            return
        
        
        #backtrack
        for i in range(index, len(nums)):
            subset.append(nums[i])
            self.helper(nums, i+1, subset, result)
            subset.pop()
        