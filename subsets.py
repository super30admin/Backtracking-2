# TC: O(2^N)
# SC: O(N)

class Solution:
    def __init__(self):
        self.result = []
        
    def dfs(self, nums, index, path):
        
        #print(index)
        self.result.append(path.copy())
        if index == len(nums):
            return
            
        for i in range(index, len(nums)):
            
            # choose
            path.append(nums[i])
            self.dfs(nums, i+1, path)
            path.pop()

    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.dfs(nums, 0, [])
        return self.result