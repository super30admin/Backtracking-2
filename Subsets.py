#Time Complexity: Exponential
#Space: O(N)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums)==0:
            return []
        self.backtrack(nums,0,[])
        return self.result
    def backtrack(self,nums,index,path):
        self.result.append(copy.copy(path))
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(nums,i+1,path)
            path.pop()