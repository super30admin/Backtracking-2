# Time Complexity :O(N*2^N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



class Solution:
    def helper(self, nums, pivot):
        # base
        if(pivot==len(nums)):
            self.result.append(self.path[:])
            return 
        if(len(self.path)):
            self.result.append(self.path[:])

        # logic
        for i in range(pivot, len(nums)):
            # action
            self.path.append(nums[i])
            # recurse
            self.helper(nums, i+1)
            # backtrack
            self.path.pop()
        

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[[]]
        self.path=[]
        self.helper(nums,0)
        return self.result