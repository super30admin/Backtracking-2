# Time Complexity : O(2^N)
# Space Complexity : O(N*2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.helper(nums,0,[])
        return self.result
        

    def helper(self,nums,pos,curr):
        if pos == len(nums):
            self.result.append(curr.copy())
            return
        # consider
        curr.append(nums[pos])
        self.helper(nums,pos+1,curr)
        #backtrack
        curr.pop()
        #don't consider
        self.helper(nums,pos+1,curr)        