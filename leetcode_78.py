class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for x in nums:
            res += [r + [x] for r in res]
        return res
