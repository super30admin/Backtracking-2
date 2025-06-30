# TC: O(n*2^n)
# SC: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        pivot=0

        def helper(nums, pivot, path, res):
            res.append(path.copy())
            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path, res)
                #backtrack
                path.pop()
        
        helper(nums,pivot, [], res)
        return res