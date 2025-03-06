class Solution:
    def __init__(self):
        self.rtnData = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0: return self.rtnData

        self.helper(nums, 0, [])

        return self.rtnData

    def helper(self, nums, index, path):
        # base
        if index == len(nums):
            self.rtnData.append(path.copy())
            return

        # logic
        # case 0 or do-not-choose
        self.helper(nums, index+1, path)

        # case 1 or choose
        # action
        path.append(nums[index])
        # recurse
        self.helper(nums, index+1, path)
        # backtrack
        path.pop()