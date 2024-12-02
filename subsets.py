class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for i in range(len(nums)):
            size = len(res)
            for j in range(size):
                temp = res[j].copy()
                temp.append(nums[i])
                res.append(temp)
        return res
   
        
