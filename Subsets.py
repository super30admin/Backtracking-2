"""
TC/SC: O(@^n)/O(1)
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for i in nums:
            for j in range(len(res)):
                res.append(res[j] + [i])
        return res
        
