# Time Complexity : O(N^N)
# Space Complexity : O(N), without recursive stack; where N is the input size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        output = []
        path = []
        self.backtracking(nums, 0, path, output)
        
        return output
        
    
    def backtracking(self, nums, index, path, output):
        
        #base case
        if index >= len(nums):
            output.append(list(path))
            return
        
        #recursive case
        #first add the root to path
        output.append(list(path))
        
        #then find all possibilties from that node
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.backtracking(nums, i+1, path, output)
            path.pop(len(path)-1)
        