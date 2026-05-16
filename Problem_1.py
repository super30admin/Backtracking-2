class Solution:
    def subsets(self, nums):
        result = []
        self.helper(0, nums, [], result)
        return result

    def helper(self, pivot, nums, path, result):
        result.append(list(path))
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(i + 1, nums, path, result)
            path.pop()


# class Solution:
#     def subsets(self, nums):
#         result = []
#         self.helper(0, nums, [], result)
#         return result

#     def helper(self, index, nums, path, result):
#         if index == len(nums):
#             result.append(list(path))
#             return

#         self.helper(index + 1, nums, path, result)
#         path.append(nums[index])
#         self.helper(index + 1, nums, path, result)
#         path.pop()