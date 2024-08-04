# Time = O(2**N)
# Space = O(N)

class Solution:
    def __init__(self):
        self.result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        self.backtrack(nums, 0, [])
        return self.result 
    
    def backtrack(self, nums, index, path):

        #logic
        self.result.append(path)
        for i in range(index, len(nums)):
            #action
            path.append(nums[i])
            # recurse 
            self.backtrack(nums, i+1, list(path))
            #backtrack 
            path.pop()
        