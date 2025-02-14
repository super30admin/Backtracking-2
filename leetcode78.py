#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return
            # inlude nums[i] in subset
            subset.append(nums[i])
            dfs(i +1)

            # do not include nums[i]
            subset.pop()
            dfs(i + 1)
        dfs(0)
        return res
    