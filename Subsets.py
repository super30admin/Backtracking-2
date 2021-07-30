import copy
class Solution:
    result = []

    def subsets(self, nums) :
        self.result = []
        if nums == None or len(nums) == 0:
            return self.result

        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, index, path):

        self.result.append(copy.deepcopy(path))

        for i in range(index, len(nums)):
            path.append(nums[i])

            self.helper(nums, i + 1, path)
            path.pop(-1)


