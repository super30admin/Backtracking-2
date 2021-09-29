#Time Complexity : O(2^n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    result = []
    def helper(self, nums, index, path):
        if index == len(nums):
            path1 = []
            path1.extend(path)
            Solution.result.append(path1)
            return
        
        self.helper(nums, index+1, path)
        path.append(nums[index])
        self.helper(nums, index+1, path)
        #backtrack
        del path[-1]
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        Solution.result = []
        path = []
        self.helper(nums, 0, path)
        return Solution.result
        