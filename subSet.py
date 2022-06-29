#Time complexity: O(n*2^n)
#Space complexity: O(n)
class Solution:
    def __init__(self):
        self.res = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #base
        
        #logic
        self.helper(nums, 0, [])
        return self.res
    def helper(self, nums, idx, path):
        
        self.res.append(path.copy())
        for i in range(idx, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            del path[-1]
    
