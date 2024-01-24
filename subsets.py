class Solution:
    def findSubset(self, i, nums, ans, ds):
        if i == len(nums):
            ans.append(ds.copy())
            return
            
        
        ds.append(nums[i])
        self.findSubset(i, nums, ans, ds)
        ds.pop()
        self.findSubset(i+1, nums, ans, ds)
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        ans = []
        ds = []
        
        self.findSubset(0, nums, ans, ds)
        
