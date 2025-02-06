class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # T: O(n ** 2), S: O(n)
        res, subset = [], []

        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return
            # Include
            subset.append(nums[i])
            dfs(i + 1)
            # Exclude
            subset.pop()
            dfs(i + 1)

        dfs(0)
        return res
