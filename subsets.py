""""
Approach: At every index choose the number/ not choose the number and move to next index, when index goes out of bounds we formed a subset, append it to the list
TC: O(n*2^n) There 2^n subsets and it takes n time to copy to res
SP: O(n) size of call stack space will be length of nums in the worst case

"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return
            subset.append(nums[i])
            dfs(i+1)
            subset.pop()
            dfs(i+1)
        dfs(0)
        return res

        